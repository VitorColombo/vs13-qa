package produtos;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ProdutosContratoTest {
    String token;
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
        int randomInt = new Random().nextInt(100);

        given()
                .log().all()
                .contentType("application/json")
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA S%s",
                          "preco": 100,
                          "descricao": "Celularzao edicao limitada",
                          "quantidade": 10
                        }
                        """ .formatted(randomInt))
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
}
