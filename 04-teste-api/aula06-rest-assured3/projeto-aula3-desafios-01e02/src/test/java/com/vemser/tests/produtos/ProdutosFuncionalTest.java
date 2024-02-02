package com.vemser.tests.produtos;

import client.ProdutoClient;
import data.factory.ProdutoDataFactory;
import io.restassured.response.Response;
import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutosFuncionalTest {

    ProdutoClient produtoClient = new ProdutoClient();

    @Test
    public void testCadastrarUsuarioComSucesso() {
        Produto produto = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoResult = produtoClient.cadastrarProduto(produto)
            .then()
                .statusCode(201)
                .extract()
                .as(ProdutoResponse.class);

        assertAll("produtoResult",
                () -> assertEquals("Cadastro realizado com sucesso", produtoResult.getMessage()),
                () -> assertNotNull(produtoResult.get_id())
        );
    }

    @ParameterizedTest
    @MethodSource("com.vemser.tests.provider.ProdutoTestDataProvider#produtosComDadosInvalidos")
    public void testCadastrarProdutoComDadosInvalidos(Produto produto, String[] mensagensEsperadas) {
        ProdutoResponse produtoResponse = produtoClient.cadastrarProduto(produto)
                .then()
                .statusCode(400)
                .extract()
                .as(ProdutoResponse.class);

        validarAtributo(produtoResponse.getNome(), mensagensEsperadas, "nome");
        validarAtributo(produtoResponse.getDescricao(), mensagensEsperadas, "descricao");
        validarAtributo(produtoResponse.getPreco(), mensagensEsperadas, "preco");
        validarAtributo(produtoResponse.getQuantidade(), mensagensEsperadas, "quantidade");
    }
    private void validarAtributo(String valorAtributo, String[] mensagensEsperadas, String nomeAtributo) {
        if (valorAtributo != null) {
            assertThat("A validação de " + nomeAtributo + " falhou", valorAtributo, isOneOf(mensagensEsperadas));
        }
    }

    @Test
    public void testCadastrarProdutoSemTokenValido(){
        Produto produto = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoResponse = produtoClient.cadastrarProdutoSemTokenValido(produto)
            .then()
                .statusCode(401)
                .extract().as(ProdutoResponse.class)
                ;
        assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", produtoResponse.getMessage());
    }

    @Test
    public void testCadastrarProdutoSemPermissao(){
        Produto produto = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoResponse = produtoClient.cadastrarProdutoSemPermissao(produto)
            .then()
                .statusCode(403)
                .extract().as(ProdutoResponse.class)
                ;
        assertEquals("Rota exclusiva para administradores", produtoResponse.getMessage());
    }

    @Test
    public void testEditarProdutoComSucesso() {
        Produto produto = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(produto).as(ProdutoResponse.class);
        Produto produtoEditado = ProdutoDataFactory.produtoValido();

        ProdutoResponse produtoResponse = produtoClient.atualizarProduto(produtoCadastrado.get_id(), produtoEditado)
                .then()
                    .statusCode(200)
                    .extract()
                    .as(ProdutoResponse.class)
                ;
        assertAll("EditarProdutoResponse",
                () -> assertEquals("Registro alterado com sucesso", produtoResponse.getMessage()),
                () -> assertNull(produtoResponse.get_id())
        );
        ProdutoResponse produtoBuscado = produtoClient.buscarProdutoPorId(produtoCadastrado.get_id())
                .then()
                    .extract()
                    .as(ProdutoResponse.class)
                ;
        assertAll("produtoBuscado",
                () -> assertEquals(produtoEditado.getNome(), produtoBuscado.getNome()),
                () -> assertEquals(produtoEditado.getPreco(), produtoBuscado.getPreco()),
                () -> assertEquals(produtoEditado.getDescricao(), produtoBuscado.getDescricao()),
                () -> assertEquals(produtoEditado.getQuantidade(), produtoBuscado.getQuantidade())
        );
    }

    @Test
    public void testEditarProdutoComIDNaoCadastrado(){
        Produto produtoEditado = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoResponse = produtoClient.atualizarProduto("idInvalido", produtoEditado)
            .then()
                .statusCode(201)
                .extract()
                .as(ProdutoResponse.class)
                ;
        assertAll("EditarProdutoResponse",
                () -> assertEquals("Cadastro realizado com sucesso", produtoResponse.getMessage()),
                () -> assertNotNull(produtoResponse.get_id())
        );
        ProdutoResponse produtoBuscado = produtoClient.buscarProdutoPorId(produtoResponse.get_id())
            .then()
                .extract()
                .as(ProdutoResponse.class)
                ;
        assertAll("produtoBuscado",
                () -> assertEquals(produtoEditado.getNome(), produtoBuscado.getNome()),
                () -> assertEquals(produtoEditado.getPreco(), produtoBuscado.getPreco()),
                () -> assertEquals(produtoEditado.getDescricao(), produtoBuscado.getDescricao()),
                () -> assertEquals(produtoEditado.getQuantidade(), produtoBuscado.getQuantidade())
        );
    }

    @Test
    public void testEditarProdutoComNomeJaCadastrado(){
        Produto produtoCriado = ProdutoDataFactory.produtoValido();
        produtoClient.cadastrarProduto(produtoCriado).as(ProdutoResponse.class);

        Produto produtoEditado = ProdutoDataFactory.produtoValido();
        produtoEditado.setNome(produtoCriado.getNome());

        ProdutoResponse produtoResponse = produtoClient.atualizarProduto("idInvalido",produtoEditado)
            .then()
                .statusCode(400)
                .extract()
                .as(ProdutoResponse.class)
                ;
        assertEquals("Já existe produto com esse nome", produtoResponse.getMessage());
    }

    @Test
    public void testEditarProdutoSemTokenValido(){
        Produto produto = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(produto).as(ProdutoResponse.class);
        Produto produtoEditado = ProdutoDataFactory.produtoValido();

        ProdutoResponse produtoResponse = produtoClient.atualizarProdutoSemTokenValido(produtoCadastrado.get_id(), produtoEditado)
            .then()
                .statusCode(401)
                .extract()
                .as(ProdutoResponse.class)
                ;
        assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", produtoResponse.getMessage());
    }

    @Test
    public void testEditarProdutoSemPermissao(){
        Produto produto = ProdutoDataFactory.produtoValido();
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(produto).as(ProdutoResponse.class);
        Produto produtoEditado = ProdutoDataFactory.produtoValido();

        ProdutoResponse produtoResponse = produtoClient.atualizarProdutoSemPermissao(produtoCadastrado.get_id(), produtoEditado)
            .then()
                .statusCode(403)
                .extract()
                .as(ProdutoResponse.class)
                ;
        assertEquals("Rota exclusiva para administradores", produtoResponse.getMessage());
    }

    @Test
    public void testeBuscarTodosProdutosCadastrados() {
        ListaProdutosResponse produtosRes = produtoClient.buscarTodosProdutos()
            .then()
                .statusCode(200)
                .extract()
                .as(ListaProdutosResponse.class)
                ;
        int quantidadeInt = Integer.parseInt(produtosRes.getQuantidade());
        assertAll("usuarioRes",
                () -> assertNotNull(produtosRes.getProdutos()),
                () -> assertTrue(produtosRes.getProdutos().size() > 0),
                () -> assertEquals(produtosRes.getProdutos().size(), quantidadeInt)
        );
    }

    @Test
    public void testeBuscarTodosProdutosCadastradosComFiltroNome() {
        Produto produto = ProdutoDataFactory.produtoValido();
        produtoClient.cadastrarProduto(produto).as(ProdutoResponse.class);

        ListaProdutosResponse produtosRes = produtoClient.buscarTodosProdutosComFiltroNome(produto.getNome())
            .then()
                .statusCode(200)
                .extract()
                .as(ListaProdutosResponse.class)
            ;
        assertAll("BuscarProdutoRes",
                () -> assertNotNull(produtosRes.getProdutos()),
                () -> assertTrue(produtosRes.getProdutos().size() > 0),
                () -> assertEquals(produtosRes.getProdutos().get(0).getNome(), produto.getNome())
        );
    }

    @Test
    public void testeBuscarTodosProdutosCadastradosComFiltroNomeGrande() {
        Produto produto = ProdutoDataFactory.produtoComNomeExtenso();
        ProdutoResponse produtoResponse = produtoClient.cadastrarProduto(produto).as(ProdutoResponse.class);

        Response response = produtoClient.buscarTodosProdutosComFiltroNome(produto.getNome())
            .then()
                .statusCode(431)
                .extract()
                .response()
            ;
        assertEquals("HTTP/1.1 431 Request Header Fields Too Large", response.getStatusLine());
    }

    @Test
    public void testeBuscarProdutoPorIdComSucesso() {
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(
                ProdutoDataFactory.produtoValido()).as(ProdutoResponse.class);
        ProdutoResponse produtoRes = produtoClient.buscarProdutoPorId(produtoCadastrado.get_id())
            .then()
                .statusCode(200)
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertAll("produtoBuscado",
                () -> assertNotNull(produtoRes.get_id()),
                () -> assertNotNull(produtoRes.getNome()),
                () -> assertNotNull(produtoRes.getPreco()),
                () -> assertNotNull(produtoRes.getDescricao()),
                () -> assertNotNull(produtoRes.getQuantidade()),
                () -> assertEquals(produtoCadastrado.get_id(), produtoRes.get_id())
        );
    }

    @Test
    public void testeBuscarProdutoPorIdComIdInvalido() {
        ProdutoResponse produtoRes = produtoClient.buscarProdutoPorId("asdasd2123")
            .then()
                .statusCode(400)
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertEquals("Produto não encontrado", produtoRes.getMessage());
    }

    @Test
    public void testExcluirProdutosComSucesso(){
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(
                ProdutoDataFactory.produtoValido()).as(ProdutoResponse.class);

        ProdutoResponse produtoResDelete = produtoClient.deletarProduto(produtoCadastrado.get_id())
            .then()
                .statusCode(200)
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertAll("produtoResDeleteComSucesso",
                () -> assertEquals("Registro excluído com sucesso", produtoResDelete.getMessage()),
                () -> assertNull(produtoResDelete.get_id())
        );

        ProdutoResponse produtoBuscado = produtoClient.buscarProdutoPorId(produtoCadastrado.get_id())
            .then()
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertEquals("Produto não encontrado", produtoBuscado.getMessage());
    }

    @Test
    public void testExcluirProdutosSemTokenValido(){
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(
                ProdutoDataFactory.produtoValido()).as(ProdutoResponse.class);

        ProdutoResponse produtoResDelete = produtoClient.deletarProdutoSemTokenValido(produtoCadastrado.get_id())
            .then()
                .statusCode(401)
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", produtoResDelete.getMessage());
    }

    @Test
    public void testExcluirProdutosSemPermissao(){
        ProdutoResponse produtoCadastrado = produtoClient.cadastrarProduto(
                ProdutoDataFactory.produtoValido()).as(ProdutoResponse.class);

        ProdutoResponse produtoResDelete = produtoClient.deletarProdutoSemPermissao(produtoCadastrado.get_id())
            .then()
                .statusCode(403)
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertEquals("Rota exclusiva para administradores", produtoResDelete.getMessage());
    }

    @Test
    public void testExcluirProdutosComIdInvalido(){
        ProdutoResponse produtoResDelete = produtoClient.deletarProduto("idInvalido")
            .then()
                .statusCode(200)
                .extract()
                .as(ProdutoResponse.class)
            ;
        assertEquals("Nenhum registro excluído", produtoResDelete.getMessage());
    }

}
