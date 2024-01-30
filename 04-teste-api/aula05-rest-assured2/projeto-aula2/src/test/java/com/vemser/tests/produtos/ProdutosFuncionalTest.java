package com.vemser.tests.produtos;

import com.google.gson.Gson;
import com.vemser.tests.pojo.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProdutosFuncionalTest {
    private String token;
    private String idUsuario;
    Faker gerador = new Faker(new Locale("pt-BR"));

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarProdutoComSucesso() {
        logarAdmin();
        ProdutosReqPojo produtoCriado = novoProduto();
        ProdutosResPojo produtosResult =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(produtoCriado)
                .header("Authorization", token)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(201)
                .extract().as(ProdutosResPojo.class)
                ;
        Assertions.assertNotNull(produtosResult.get_id());
        ProdutosResPojo produtosReq = buscarProdutoPorID(produtosResult.get_id());
        Assertions.assertEquals(produtosReq.getNome(), produtoCriado.getNome());
        Assertions.assertEquals(produtosReq.getPreco(), produtoCriado.getPreco());
        Assertions.assertEquals(produtosReq.getDescricao(), produtoCriado.getDescricao());
        Assertions.assertEquals(produtosReq.getQuantidade(), produtoCriado.getQuantidade());
        Assertions.assertEquals("Cadastro realizado com sucesso", produtosResult.getMessage());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testBuscarProdutoPorIDComSucesso() {
        logarAdmin();
        ProdutosResPojo produtoCriado = buscarProdutoPorID(cadastrarProduto().get_id());
        ProdutosReqPojo produtoReq = convertToProdutosReqPojoGson(produtoCriado);

        ProdutosResPojo produtoBuscado =
        given()
                .log().all()
                .pathParam("_id", produtoCriado.get_id())
        .when()
                .get("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("_id", notNullValue())
                .extract().as(ProdutosResPojo.class)
        ;
        Assertions.assertEquals(produtoReq.getNome(), produtoBuscado.getNome());
        Assertions.assertEquals(produtoReq.getPreco(), produtoBuscado.getPreco());
        Assertions.assertEquals(produtoReq.getDescricao(), produtoBuscado.getDescricao());
        Assertions.assertEquals(produtoReq.getQuantidade(), produtoBuscado.getQuantidade());
        Assertions.assertNotEquals(produtoBuscado.get_id(), null);
    }

    @Test
    public void testListarProdutosCadastradosComSucesso() {
        ProdutosCadastradosResPojo produtosResult =
        given()
            .log().all()
        .when()
            .get("/produtos")
        .then()
            .statusCode(200)
            .header("Content-Type", "application/json; charset=utf-8")
            .time(lessThan(1000L))
            .extract().as(ProdutosCadastradosResPojo.class)
            ;
        Assertions.assertEquals(produtosResult.getQuantidade(), produtosResult.getProdutos().size());
        Assertions.assertTrue(produtosResult.getQuantidade() >= 0);
        Assertions.assertTrue(produtosResult.getProdutos().size() >= 0)
        ;
    }

    @Test
    public void testEditarProdutoComSucesso() {
        logarAdmin();
        ProdutosResPojo produtoEditar = buscarProdutoPorID(cadastrarProduto().get_id());
        ProdutosReqPojo produtoEditado = convertToProdutosReqPojoGson(produtoEditar);
        produtoEditado.setDescricao(gerador.commerce().productName() + " EDITADO");
        produtoEditado.setNome(gerador.commerce().productName() + " EDITADO");

        given()
                .log().all()
                .pathParam("_id", produtoEditar.get_id())
                .contentType(ContentType.JSON)
                .body(produtoEditado)
                .header("Authorization", token)
        .when()
                .put("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"))
        ;
        ProdutosResPojo produtoResult = buscarProdutoPorID(produtoEditar.get_id());
        Assertions.assertNotEquals(produtoResult.get_id(), null);
        Assertions.assertEquals(produtoEditado.getDescricao(), produtoResult.getDescricao());
        Assertions.assertEquals(produtoEditado.getNome(), produtoResult.getNome());
        Assertions.assertEquals(produtoEditado.getPreco(), produtoResult.getPreco());
        Assertions.assertEquals(produtoEditado.getQuantidade(), produtoResult.getQuantidade());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testExcluirProdutosComSucesso() {
        logarAdmin();
        ProdutosResPojo produtoCriado = buscarProdutoPorID(cadastrarProduto().get_id());

        given()
                .log().all()
                .pathParam("_id", produtoCriado.get_id())
                .header("Authorization", token)
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"))
        ;
        ProdutosResPojo produtoExcluido = buscarProdutoPorID(produtoCriado.get_id());
        Assertions.assertEquals(produtoExcluido.getMessage(), "Produto não encontrado");
        Assertions.assertNull(produtoExcluido.get_id());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testCadastrarProdutoSemToken() {
        ProdutosReqPojo produtoCriado = novoProduto();
        ProdutosResPojo produtosResult =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(produtoCriado)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(401)
                .extract().as(ProdutosResPojo.class)
        ;
        Assertions.assertNull(produtosResult.get_id());
        Assertions.assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", produtosResult.getMessage());
        }

    @Test
    public void testBuscarProdutoPorIDcomIDinvalido() {
        String idProdutoInvalido = "aasdasdasd";

        ProdutosResPojo produtoBuscado =
        given()
                .log().all()
                .pathParam("_id", idProdutoInvalido)
        .when()
                .get("/produtos/{_id}")
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(1000L))
                .statusCode(400)
                .extract().as(ProdutosResPojo.class)
        ;
        Assertions.assertNull(produtoBuscado.get_id());
        Assertions.assertEquals("Produto não encontrado", produtoBuscado.getMessage());
    }

    @Test
    public void testEditarProdutoSemToken() {
        logarAdmin();
        ProdutosResPojo produtoEditar = buscarProdutoPorID(cadastrarProduto().get_id());
        excluirUsuarioPorID(idUsuario);
        logar();
        ProdutosReqPojo produtoEditado = convertToProdutosReqPojoGson(produtoEditar);
        produtoEditado.setDescricao(gerador.commerce().productName() + " EDITADO");

        ProdutosResPojo produtoResult =
        given()
                .log().all()
                .pathParam("_id", produtoEditar.get_id())
                .contentType(ContentType.JSON)
                .body(produtoEditado)
        .when()
                .put("/produtos/{_id}")
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(1000L))
                .statusCode(401)
                .extract().as(ProdutosResPojo.class)
                ;
        Assertions.assertNull(produtoResult.get_id());
        Assertions.assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", produtoResult.getMessage());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testExcluirProdutosSemToken() {
        logarAdmin();
        ProdutosResPojo produtoCriado = buscarProdutoPorID(cadastrarProduto().get_id());
        excluirUsuarioPorID(idUsuario);
        logar();

        ProdutosResPojo produtoResult =
        given()
                .log().all()
                .pathParam("_id", produtoCriado.get_id())
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(1000L))
                .statusCode(401)
                .extract().as(ProdutosResPojo.class)
        ;
        Assertions.assertNull(produtoResult.get_id());
        Assertions.assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", produtoResult.getMessage());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testCadastrarProdutoSemPermissao() {
        logar();
        ProdutosReqPojo produtoCriado = novoProduto();
        ProdutosResPojo produtosResult =
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(produtoCriado)
                .header("Authorization", token)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(403)
                .extract().as(ProdutosResPojo.class)
                ;
        Assertions.assertNull(produtosResult.get_id());
        Assertions.assertEquals("Rota exclusiva para administradores", produtosResult.getMessage());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testEditarProdutoSemPermissao() {
        logarAdmin();
        ProdutosResPojo produtoEditar = buscarProdutoPorID(cadastrarProduto().get_id());
        excluirUsuarioPorID(idUsuario);
        logar();
        ProdutosReqPojo produtoEditado = convertToProdutosReqPojoGson(produtoEditar);
        produtoEditado.setDescricao(gerador.commerce().productName() + " EDITADO");
        produtoEditado.setNome(gerador.commerce().productName() + " EDITADO");

        given()
                .log().all()
                .pathParam("_id", produtoEditar.get_id())
                .contentType(ContentType.JSON)
                .body(produtoEditado)
                .header("Authorization", token)
        .when()
                .put("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(403)
                .body("message", equalTo("Rota exclusiva para administradores"))
        ;
        Assertions.assertNotEquals(produtoEditar.get_id(), null);
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testExcluirProdutosSemPermissao() {
        logarAdmin();
        ProdutosResPojo produtoCriado = buscarProdutoPorID(cadastrarProduto().get_id());
        excluirUsuarioPorID(idUsuario);
        logar();

        given()
                .log().all()
                .pathParam("_id", produtoCriado.get_id())
                .header("Authorization", token)
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(403)
                .body("message", equalTo("Rota exclusiva para administradores"))
        ;
        ProdutosResPojo produtosResult = buscarProdutoPorID(produtoCriado.get_id());
        Assertions.assertEquals(produtosResult.get_id(), produtoCriado.get_id());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testBuscarProdutoPorIDComIDInvalido() {
        logar();
        given()
                .log().all()
                .pathParam("_id", "asdasd2123")
        .when()
                .get("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(400)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("message", equalTo("Produto não encontrado"))
        ;
    }

    @Test
    public void testListarProdutosCadastradosComFiltroNome() {
        logarAdmin();
        ProdutosResPojo produtoCriado = buscarProdutoPorID(cadastrarProduto().get_id());
        excluirUsuarioPorID(idUsuario);
        logar();
        ProdutosReqPojo produtoReq = convertToProdutosReqPojoGson(produtoCriado);

        ProdutosCadastradosResPojo response =
        given()
                .log().all()
                .queryParam("nome", produtoReq.getNome())
        .when()
                .get("/produtos")
        .then()
                .log().all()
                .statusCode(200)
                .body("produtos", hasSize(greaterThan(0)))
                .time(lessThan(1000L))
                .extract().as(ProdutosCadastradosResPojo.class)
        ;
        Assertions.assertNotEquals(response.getProdutos().get(0).get_id(), null);
        Assertions.assertEquals(produtoReq.getNome(), response.getProdutos().get(0).getNome());
        Assertions.assertEquals(produtoReq.getPreco(), response.getProdutos().get(0).getPreco());
        Assertions.assertEquals(produtoReq.getDescricao(), response.getProdutos().get(0).getDescricao());
        Assertions.assertEquals(produtoReq.getQuantidade(), response.getProdutos().get(0).getQuantidade());
        excluirUsuarioPorID(idUsuario);
    }

    @Test
    public void testListarProdutosCadastradosComFiltroNomeInvalido() {

        given()
                .log().all()
                .queryParam("nome", 1231)
                .when()
                .get("/produtos")
                .then()
                .log().all()
                .statusCode(500)
        ;
    }

    private void logarAdmin(){
        UsuariosReqPojo usuarioAdmin = cadastrarUsuarioAdmin();
        login(usuarioAdmin.getEmail(), usuarioAdmin.getPassword());
    }
    private UsuariosReqPojo cadastrarUsuarioAdmin() {
        UsuariosReqPojo usuariosReqPojo = new UsuariosReqPojo();
        usuariosReqPojo.setAdministrador("true");
        usuariosReqPojo.setEmail(gerador.internet().emailAddress());
        usuariosReqPojo.setNome(gerador.name().fullName());
        usuariosReqPojo.setPassword(gerador.internet().password());
        UsuariosResPojo usuarioResult = cadastrarUsuario(usuariosReqPojo);
        idUsuario = usuarioResult.get_id();

        return usuariosReqPojo;
    }

    private void logar(){
        UsuariosReqPojo usuarioNormal = cadastrarUsuarioNormal();
        login(usuarioNormal.getEmail(), usuarioNormal.getPassword());
    }
    private UsuariosReqPojo cadastrarUsuarioNormal() {
        UsuariosReqPojo usuariosReqPojo = new UsuariosReqPojo();
        usuariosReqPojo.setAdministrador("false");
        usuariosReqPojo.setEmail(gerador.internet().emailAddress());
        usuariosReqPojo.setNome(gerador.name().fullName());
        usuariosReqPojo.setPassword(gerador.internet().password());

        UsuariosResPojo usuarioResult = cadastrarUsuario(usuariosReqPojo);
        idUsuario = usuarioResult.get_id();

        return usuariosReqPojo;
    }

    private UsuariosResPojo cadastrarUsuario(UsuariosReqPojo usuariosReqPojo) {
        UsuariosResPojo usuarioResult =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(usuariosReqPojo)
                        .when()
                        .post("usuarios").as(UsuariosResPojo.class);
        return usuarioResult;
    }

    private void excluirUsuarioPorID(String id) {
        given()
                .log().all()
                .pathParam("_id", id)
                .when()
                .delete("/usuarios/{_id}")
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"))
        ;
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

    private ProdutosResPojo buscarProdutoPorID(String id){
        ProdutosResPojo produtoResult =
                given()
                        .pathParam("_id", id)
                        .when()
                        .get("produtos/{_id}").as(ProdutosResPojo.class)
                ;
        return produtoResult;
    }

    private ProdutosReqPojo novoProduto(){
        ProdutosReqPojo produtosReqPojo = new ProdutosReqPojo();
        produtosReqPojo.setNome(gerador.commerce().productName());
        produtosReqPojo.setPreco(gerador.number().numberBetween(1, 100));
        produtosReqPojo.setDescricao(gerador.commerce().material() + " " + gerador.commerce().brand());
        produtosReqPojo.setQuantidade(gerador.number().numberBetween(1, 1000));

        return produtosReqPojo;
    }

    private ProdutosReqPojo convertToProdutosReqPojoGson(ProdutosResPojo produtosResPojo){
        Gson gson = new Gson();
        String json = gson.toJson(produtosResPojo);
        ProdutosReqPojo produtosReqPojo = gson.fromJson(json, ProdutosReqPojo.class);
        return produtosReqPojo;
    }

    private ProdutosResPojo cadastrarProduto(){
        ProdutosReqPojo produtosReqPojo = novoProduto();
        ProdutosResPojo produtosResult =
                given()
                    .header("Authorization", token)
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(produtosReqPojo)
                .when()
                    .post("produtos").as(ProdutosResPojo.class)
                ;
        return produtosResult;
    }
}
