package com.vemser.tests.usuarios;

import com.google.gson.Gson;
import com.vemser.tests.pojo.UsuariosReqPojo;
import com.vemser.tests.pojo.UsuariosResPojo;
import io.restassured.http.ContentType;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import java.util.Locale;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosFuncionalTest {

    Faker gerador = new Faker(new Locale("pt-BR"));
    Random geradorBool = new Random();

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000/";
    }

    @Test
    public void testCadastrarUsuarioComSucesso() {

        UsuariosResPojo usuariosResult =
        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(novoUsuario())
        .when()
            .post("usuarios")
        .then()
            .log().all()
                .statusCode(201)
                .extract().as(UsuariosResPojo.class)
                ;
        Assertions.assertEquals("Cadastro realizado com sucesso", usuariosResult.getMessage());
        Assertions.assertNotNull(usuariosResult.get_id());
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
        //pre-req: usuario cadastrado
        UsuariosResPojo usuarioEditar = buscarUsuarioPorID(cadastrarUsuario().get_id());

        //preciso converter o objeto de resposta para um objeto de requisicao
        UsuariosReqPojo usuarioEditado = convertToUsuarioReqPojoGson(usuarioEditar);
        usuarioEditado.setEmail(gerador.internet().emailAddress());

        given()
                .log().all()
                .pathParam("_id", usuarioEditar.get_id())
                .contentType(ContentType.JSON)
                .body(usuarioEditado)
        .when()
            .put("usuarios/{_id}")
        .then()
            .log().all()
            .statusCode(200)
            .body("message", equalTo("Registro alterado com sucesso"))
        ;
        //testes de validacao caso o dev tenha errado
        UsuariosResPojo usuarioResult = buscarUsuarioPorID(usuarioEditar.get_id());
        Assertions.assertEquals(usuarioEditar.getNome(), usuarioResult.getNome());
        Assertions.assertEquals(usuarioEditado.getEmail(), usuarioResult.getEmail());
        Assertions.assertEquals(usuarioEditar.getPassword(), usuarioResult.getPassword());
        Assertions.assertEquals(usuarioEditar.getAdministrador(), usuarioResult.getAdministrador());
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

    private UsuariosResPojo buscarUsuarioPorID(String id){
        UsuariosResPojo usuarioResult =
        given()
            .pathParam("_id", id)
        .when()
            .get("usuarios/{_id}").as(UsuariosResPojo.class)
        ;
        return usuarioResult;
    }

    private UsuariosReqPojo novoUsuario(){
        UsuariosReqPojo usuariosReqPojo = new UsuariosReqPojo();
        usuariosReqPojo.setNome(gerador.name().firstName() + " " + gerador.name().lastName());
        usuariosReqPojo.setEmail(gerador.internet().emailAddress());
        usuariosReqPojo.setPassword(gerador.internet().password());
        usuariosReqPojo.setAdministrador(geradorBool.nextBoolean() ? "true" : "false");

        return usuariosReqPojo;
    }

    private UsuariosReqPojo convertToUsuarioReqPojoGson(UsuariosResPojo usuariosResPojo){
        Gson gson = new Gson();
        String json = gson.toJson(usuariosResPojo);
        UsuariosReqPojo usuariosReqPojo = gson.fromJson(json, UsuariosReqPojo.class);
        return usuariosReqPojo;
    }

    private UsuariosResPojo cadastrarUsuario(){

        UsuariosReqPojo usuariosReqPojo = novoUsuario();
        UsuariosResPojo usuarioResult =
        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body(usuariosReqPojo)
        .when()
            .post("usuarios").as(UsuariosResPojo.class)
        ;
        return usuarioResult;
    }

}


