package com.vemser.tests.produtos;

import com.vemser.tests.pojo.ProdutosReqPojo;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.datafaker.Faker;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ProdutosContratoTest {
    String token;

    Faker gerador = new Faker(new Locale("pt-BR"));

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testValidarContratoBuscarProdutoPorID() {
        String idProduto = "52ECGvSnpISze3VX";

        given()
                .log().all()
                .pathParam("_id", idProduto)
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                        "schemas/produtos/busca_produto_id.json"))
        ;
    }

    @Test
    public void testValidarContratoCadastrarProduto() {
        logarAdmin();
        ProdutosReqPojo produtoCriado = novoProduto();

        given()
                .log().all()
                .contentType("application/json")
                .body(produtoCriado)
                .header("Authorization", token)
        .when()
                .post("/produtos")
        .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                        "schemas/produtos/post_produtos.json"))
        ;
    }

    private void logarAdmin(){
        String email = "alyson.pesqueira@qa.com.br";
        String password = "teste";
        login(email, password);
    }

    private void login(String email, String password){
        token = given()
                .contentType(ContentType.JSON)
                .body("""
                    {
                      "password": "%s",
                      "email": "%s"
                    }
                    """.formatted(password, email))
                .when()
                .post("/login")
                .path("authorization");
    }
    private ProdutosReqPojo novoProduto(){
        ProdutosReqPojo produtosReqPojo = new ProdutosReqPojo();
        produtosReqPojo.setNome(gerador.commerce().productName());
        produtosReqPojo.setPreco(gerador.number().numberBetween(1, 100));
        produtosReqPojo.setDescricao(gerador.commerce().material() + " " + gerador.commerce().brand());
        produtosReqPojo.setQuantidade(gerador.number().numberBetween(1, 1000));

        return produtosReqPojo;
    }
}
