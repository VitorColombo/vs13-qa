package com.vemser.tests.usuarios;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class UsuariosContratoTest {
    @BeforeEach
    public void setUp() {
        String baseURI = "http://localhost:3000/";
    }

    @Test
    public void testValidarContratoBuscarPorID(){
        String id = "V32IXizaYNlSu4KI";

        given()
                .log().all()
                .pathParam("_id", id)
        .when()
                .get(baseURI + "/usuarios/{_id}")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/usuarios/usuarios-schema.json"))
        ;
    }
    public void testValidarContratoBuscarPorID(){
        String id = "V32IXizaYNlSu4KI";

        given()
                .log().all()
                .pathParam("_id", id)
                .when()
                .get(baseURI + "/usuarios/{_id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/usuarios/usuarios-schema.json"))
        ;
    }

}
