package com.vemser.tests.produtos;

import client.AuthClient;
import data.factory.ProdutoDataFactory;
import io.restassured.module.jsv.JsonSchemaValidator;
import model.Login;
import model.LoginResponse;
import model.Produto;
import net.datafaker.Faker;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Auth;

import java.util.Locale;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ProdutosContratoTest {
    Faker gerador = new Faker(new Locale("pt-BR"));
    AuthClient authClient = new AuthClient();

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
        Produto produto = ProdutoDataFactory.produtoValido();
        Auth auth = new Auth();
        String token = auth.tokenAdmin();

        given()
                .log().all()
                .contentType("application/json")
                .body(produto)
                .header("Authorization", token)
        .when()
                .post("/produtos")
        .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                        "schemas/produtos/post_produtos.json"))
        ;
    }
}
