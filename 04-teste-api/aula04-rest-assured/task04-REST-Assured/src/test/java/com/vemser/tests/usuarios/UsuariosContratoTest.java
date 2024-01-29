package com.vemser.tests.usuarios;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UsuariosContratoTest {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testValidarContratoBuscarProdutoPorID() {
        String idUsuario = "L3TJKnokydNW2D6c";

        given()
                .log().all()
                .pathParam("_id", idUsuario)
        .when()
                .get("/usuarios/{_id}")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                        "schemas/busca_usuario_id.json"))
        ;
    }
}
