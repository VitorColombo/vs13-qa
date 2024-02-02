package com.vemser.tests.usuarios;

import client.UsuarioClient;
import data.factory.UsuarioDataFactory;
import io.restassured.response.Response;
import model.ListaUsuariosResponse;
import model.Usuario;
import model.UsuarioResponse;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsuariosFuncionalTest {
    UsuarioClient usuarioClient = new UsuarioClient();

    @Test
    public void testCadastrarUsuarioComSucesso() {
        Usuario usuario = UsuarioDataFactory.usuarioValido();

        UsuarioResponse usuarioResult = usuarioClient.cadastrarUsuario(usuario)
                .then()
                        .statusCode(201)
                        .extract().as(UsuarioResponse.class)
                ;

        assertAll("usuarioResult",
                () -> assertEquals("Cadastro realizado com sucesso", usuarioResult.getMessage()),
                () -> assertNotNull(usuarioResult.get_id())
        );
    }

    @Test
    public void testCadastrarUsuarioComDadosAusentes() {
        Usuario usuarioComDadosAusentes = UsuarioDataFactory.usuarioComDadosAusente();

        UsuarioResponse usuarioResponse = usuarioClient.cadastrarUsuario(usuarioComDadosAusentes)
                .then()
                    .log().all()
                    .statusCode(400)
                    .extract().as(UsuarioResponse.class)
                ;

        assertAll("usuarioResponse",
                () -> assertEquals("nome não pode ficar em branco", usuarioResponse.getNome()),
                () -> assertEquals( "email não pode ficar em branco" , usuarioResponse.getEmail()),
                () -> assertEquals("password não pode ficar em branco", usuarioResponse.getPassword()),
                () -> assertEquals("administrador deve ser 'true' ou 'false'", usuarioResponse.getAdministrador())
        );
    }

    @Test
    public void testEditarUsuarioComSucesso() {

        UsuarioResponse usuarioCadastrado = usuarioClient.cadastrarUsuario(
                UsuarioDataFactory.usuarioValido()).as(UsuarioResponse.class);

        usuarioClient.atualizarUsuario(usuarioCadastrado.get_id(), UsuarioDataFactory.usuarioValido())
            .then()
                    .statusCode(200)
                    .body("message", equalTo("Registro alterado com sucesso"))
            ;
    }

    @Test
    public void testEditarUsuarioComDadosAusentes() {
        UsuarioResponse usuarioCadastrado = usuarioClient.cadastrarUsuario(
                UsuarioDataFactory.usuarioValido()).as(UsuarioResponse.class);

        Usuario usuarioComDadosAusentes = UsuarioDataFactory.usuarioComDadosAusente();

        UsuarioResponse usuarioResponse = usuarioClient.atualizarUsuario(usuarioCadastrado.get_id(), usuarioComDadosAusentes)
                .then()
                    .statusCode(400)
                    .extract().as(UsuarioResponse.class)
                ;

        assertAll("usuarioResponse",
                () -> assertEquals("nome não pode ficar em branco", usuarioResponse.getNome()),
                () -> assertEquals( "email não pode ficar em branco" , usuarioResponse.getEmail()),
                () -> assertEquals("password não pode ficar em branco", usuarioResponse.getPassword()),
                () -> assertEquals("administrador deve ser 'true' ou 'false'", usuarioResponse.getAdministrador())
        );
    }


    @Test
    public void testeBuscarTodosUsuarios() {
        ListaUsuariosResponse usuarioRes = usuarioClient.buscarTodosUsuarios()
                .then()
                    .statusCode(200)
                    .extract().as(ListaUsuariosResponse.class)
                ;
        assertAll("usuarioRes",
                () -> assertNotNull(usuarioRes.getUsuarios()),
                () -> assertTrue(usuarioRes.getUsuarios().size() > 0),
                () -> assertEquals(usuarioRes.getUsuarios().size(), usuarioRes.getQuantidade())
        );
    }

    @Test
    public void testeBuscarUsuarioPorId() {
        UsuarioResponse usuarioCadastrado = usuarioClient.cadastrarUsuario(
                UsuarioDataFactory.usuarioValido()).as(UsuarioResponse.class);

        UsuarioResponse usuarioRes = usuarioClient.buscarUsuarioPorId(usuarioCadastrado.get_id())
                .then()
                    .extract().as(UsuarioResponse.class)
                ;
        assertAll("usuarioCadastrado",
                () -> assertNotNull(usuarioRes.get_id()),
                () -> assertNotNull(usuarioRes.getNome()),
                () -> assertNotNull(usuarioRes.getEmail()),
                () -> assertNotNull(usuarioRes.getPassword()),
                () -> assertNotNull(usuarioRes.getAdministrador()),
                () -> assertEquals(usuarioCadastrado.get_id(), usuarioRes.get_id())
        );
    }

    @Test
    public void testeExcluirUsuario() {
        UsuarioResponse usuarioCadastrado = usuarioClient.cadastrarUsuario(
                UsuarioDataFactory.usuarioValido()).as(UsuarioResponse.class);

        UsuarioResponse usuarioRes = usuarioClient.deletarUsuario(usuarioCadastrado.get_id())
                .then()
                    .statusCode(200)
                    .extract().as(UsuarioResponse.class)
                ;
        assertAll("usuarioExcluido",
                () -> assertEquals("Registro excluído com sucesso", usuarioRes.getMessage()),
                () -> assertNull(usuarioRes.get_id())
        );
    }

}
