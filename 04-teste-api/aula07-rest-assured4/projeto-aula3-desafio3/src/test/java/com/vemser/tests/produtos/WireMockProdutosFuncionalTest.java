package com.vemser.tests.produtos;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import client.ProdutoClient;
import data.factory.ProdutoDataFactory;
import io.restassured.http.ContentType;
import model.ListaProdutosResponse;
import model.Produto;
import model.ProdutoResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import utils.Auth;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(WireMockExtension.class)
public class WireMockProdutosFuncionalTest {

    private static ProdutoClient produtoClient = new ProdutoClient();
    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void setUp() {

        wireMockServer = new WireMockServer(8082);
        wireMockServer.start();
        produtoClient.setPort(wireMockServer.port());
        int wireMockPort = wireMockServer.port();
        System.out.println("WireMock rodando na porta: " + wireMockPort);
    }
    @BeforeEach
    public void clearWireMockStubs() {
        WireMock.reset();
    }
    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
        produtoClient.setPort(3000);
        System.out.println("WireMock parou");
    }

    @Test
    public void testCadastrarProdutoComSucesso() {
        stubFor(post(urlEqualTo("/produtos"))
                .withRequestBody(equalToJson("{ \"nome\": \"Logitech MX Vertical\", \"preco\": 470, \"descricao\": \"Mouse\", \"quantidade\": 381 }"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/Response200/cadastrarProdutoComSucesso.json")));

        ProdutoResponse resp =
            given()
                .baseUri("http://localhost")
                    .port(8082)
                    .contentType(ContentType.JSON)
            .when()
                    .post("/produtos")
            .then()
                    .statusCode(201)
                    .extract()
                    .as(ProdutoResponse.class);
            assertEquals("1", resp.get_id());
            assertEquals("Cadastro realizado com sucesso", resp.getMessage());
    }

    @Test
    public void testDeletarProdutoComSucesso() {
        stubFor(delete("/produtos/1")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/Response200/deletarProdutoComSucesso.json")));

        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .delete("/produtos/1")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(ProdutoResponse.class);
        assertTrue(response.getMessage().contains("Registro excluído com sucesso") ||
                                response.getMessage().contains("Nenhum registro excluído"));
    }

    @Test
    public void testAtualizarProdutoComSucesso(){
        stubFor(put("/produtos/1")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/Response200/atualizarProdutoComSucesso.json")));

        Produto produto = new Produto();
        produto.setNome("Produto EDITADO");
        produto.setPreco("100");
        produto.setQuantidade("10");
        produto.setDescricao("Descrição do produto 1");

        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                        .body(produto)
                .when()
                        .put("/produtos/1")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(ProdutoResponse.class);
        assertEquals("Registro alterado com sucesso", response.getMessage());
    }

    @Test
    public void testBuscarProdutoPorIdComSucesso() {
        stubFor(get("/produtos/1")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/Response200/buscarProdutoPeloID.json")));
        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .get("/produtos/1")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(ProdutoResponse.class);

        assertEquals("1", response.get_id());
        assertEquals("Produto 1", response.getNome());
        assertEquals("100", response.getPreco());
        assertEquals("10", response.getQuantidade());
        assertEquals("Descrição do produto 1", response.getDescricao());
    }

    @Test
    public void testBuscarProdutoPorIdInvalido() {
        stubFor(get("/produtos/1a2asd")
                .willReturn(aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/Response200/buscarProdutoPeloID.json")));
        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .get("/produtos/1a2asd")
                .then()
                        .statusCode(400)
                        .extract()
                        .as(ProdutoResponse.class);
        assertEquals("Produto não encontrado", response.getMessage());
    }

    @Test
    public void testBuscarTodosProdutosComSucesso() {
        stubFor(get("/produtos")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/Response200/buscarTodosProdutos.json")));
        ListaProdutosResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .get("/produtos")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(ListaProdutosResponse.class);
        assertEquals(response.getQuantidade(), "2");
        assertEquals(response.getProdutos().size(), 2);
        assertNotNull(response.getProdutos());
    }

    @Test
    public void testBuscarProdutoPorNomeComSucesso() {
        stubFor(get("/produtos?nome=Produto1")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("mappings/buscarProdutoPeloNome.json")));
        ListaProdutosResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .get("/produtos?nome=Produto1")
                .then()
                        .statusCode(200)
                        .extract()
                        .as(ListaProdutosResponse.class);
        assertEquals(response.getQuantidade(), "1");
        assertEquals(response.getProdutos().size(), 1);
        assertNotNull(response.getProdutos());
        assertEquals("Produto1", response.getProdutos().get(0).getNome());
    }

    @Test
    public void testCadastrarProdutoComNomeEmUso() {
        stubFor(post(urlEqualTo("/produtos"))
                .willReturn(aResponse()
                        .withStatus(400)
                        .withBodyFile("mappings/Response400/cadastrarProdutoComNomeEmUso.json")));

        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .post("/produtos")
                .then()
                        .statusCode(400)
                        .extract()
                        .as(ProdutoResponse.class);
        assertEquals("Já existe produto com esse nome", response.getMessage());
    }
    @Test
    public void testCadastrarProdutoSemPermissao(){
        stubFor(post(urlEqualTo("/produtos"))
                .willReturn(aResponse()
                        .withStatus(403)
                        .withBodyFile("mappings/cadastrarProdutoSemPermissao.json")));

        Produto produto = ProdutoDataFactory.produtoValido();

        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                        .body(produto)
                        .when()
                        .post("/produtos")
                        .then()
                        .statusCode(403)
                        .extract()
                        .as(ProdutoResponse.class);
        assertEquals("Rota exclusiva para administradores", response.getMessage());
    }

    @Test
    public void testDeletarProdutoSemPermissao(){
        stubFor(delete(urlEqualTo("/produtos/1"))
                .willReturn(aResponse()
                        .withStatus(403)
                        .withBodyFile("mappings/Response403/deletarProdutoSemPermissao.json")));

        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                .when()
                        .delete("/produtos/1")
                .then()
                        .statusCode(403)
                        .extract()
                        .as(ProdutoResponse.class);
        assertEquals("Rota exclusiva para administradores", response.getMessage());
    }

    @Test
    public void testAtualizarProdutoComNomeEmUso(){
        stubFor(put(urlEqualTo("/produtos/12"))
                .willReturn(aResponse()
                        .withStatus(400)
                        .withBodyFile("mappings/Response400/atualizarProdutoComNomeEmUso.json")));

        Produto produto = ProdutoDataFactory.produtoValido();

        ProdutoResponse response =
                given()
                        .baseUri("http://localhost")
                        .port(8082)
                        .contentType(ContentType.JSON)
                        .body(produto)
                .when()
                        .put("/produtos/12")
                .then()
                        .statusCode(400)
                        .extract()
                        .as(ProdutoResponse.class);
        assertEquals("Já existe produto com esse nome", response.getMessage());
    }
}
