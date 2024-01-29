package com.vemser.tests.usuarios;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000/";
    }

    @Test
    public void testCadastrarUsuarioComSucesso() {
        given()
            .contentType(ContentType.JSON)
            .body("""
                      {
                      "nome": "adasdas ddd asdasdda Silva",
                      "email": "pedrasaasdasdasdasdadaddo@restAssured.com.br",
                      "password": "taeste",
                      "administrador": "true"
                   }
                    """)
        .when()
            .post("usuarios")
        .then()
            .log().all()
            .statusCode(201)
        ;
    }

    @Test
    public void testBuscarUsuarioPorIDComSucesso() {
        String id = "llyiXjsXXxu9U6UW";
        given()
            .log().all()
            .pathParam("_id", id)
        .when()
            .get("usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(1000L))
                .body("nome", equalTo("adasdas ddd da Silva"))
                .body("_id", notNullValue())
        ;
    }

    @Test
    public void testAtualizarCadastroUsuarioComSucesso() {
        String id = "HMfh7D7dYqrI1MhB";
        given()
                .log().all()
                .pathParam("_id", id)
                .contentType(ContentType.JSON)
                .body("""
                           {
                           "nome": "asdasasdasdsaddddasd da Silva",
                           "email": "pedasdasdasrddsasdao@restAssured.com.br",
                           "password": "teste",
                           "administrador": "true"
                        }
                         """)
        .when()
            .put("usuarios/{_id}")
        .then()
            .log().all()
            .statusCode(200)
        ;
    }

    @Test
    public void testDeletarUsuarioComSucesso() {
        String id = "HMfh7D7dYqrI1MhB";
        given()
            .log().all()
            .pathParam("_id", id)
        .when()
            .delete("usuarios/{_id}")
        .then()
            .log().all()
            .statusCode(200);
    }
}
