package com.vemser.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class OlaMundoTest {

    @Test
    public void testBuscarUsuarioPorIDComSucesso() {

        //Definir URL da API
        baseURI = "https://reqres.in/";

        given()
                .log().all()
                .contentType("application/json")
            .when()
                .get("/api/users/2")

            .then()
                .log().all()
                .statusCode(200);
    }
}
