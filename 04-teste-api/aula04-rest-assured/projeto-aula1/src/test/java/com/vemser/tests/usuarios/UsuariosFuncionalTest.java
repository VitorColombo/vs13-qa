package com.vemser.tests.usuarios;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarUsuarioComSucesso() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Alyson Santa Cruz",
                          "email": "alyson.pesqueira@qa.com.br",
                          "password": "teste",
                          "administrador": "true"
                        }
                        """)
        .when()
                .post("/usuarios")
        .then()
                .log().all()
                .statusCode(201)
        ;
    }

    @Test
    public void testBuscarUsuariosCadastradosComSucesso() {
        given()
                .log().all()
                .when()
                .get("/usuarios/")
                .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
        ;
    }

    @Test
    public void testBuscarUsuarioPorIDComSucesso() {
        String idUsuario = "YPRM3xqL41P7pfgV";

        given()
                .log().all()
                .pathParam("_id", idUsuario)
        .when()
                .get("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                //.time(lessThan(1000L))
                .body("nome", equalTo("Alyson Santa Cruz"))
                .body("_id", notNullValue())
        ;
    }

    @Test
    public void testListarUsuariosCadastradosComSucesso() {

        given()
                .log().all()
                //.queryParam("email", "alyson.silva@qa.com.br")
        .when()
                .get("/usuarios")
        .then()
                .log().all()
                .statusCode(200)
                .body("usuarios.findAll{it.nome.contains('Ale')}[0].nome", is("Alessandra Mariana Scarpari"))
        ;
    }

    @Test
    public void testEditarUsuarioComSucesso() {
        String idUsuario = "DEnkcSKFv886WlFi";

        given()
                .log().all()
                .pathParam("_id", idUsuario)
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Alyson Santos Serie B",
                          "email": "alyson.santa@qa.com.br",
                          "password": "teste",
                          "administrador": "true"
                        }
                        """)
        .when()
                .put("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testExcluirUsuarioComSucesso() {
        String idUsuario = "DEnkcSKFv886WlFi";

        given()
                .log().all()
                .pathParam("_id", idUsuario)
        .when()
                .delete("/usuarios/{_id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }
}
