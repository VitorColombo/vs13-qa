package client;

import io.restassured.response.Response;
import model.Produto;
import specs.ProdutoSpecs;
import utils.Auth;

import static io.restassured.RestAssured.given;

public class ProdutoClient {

    Auth auth = new Auth();
    String tokenAdmin;
    String tokenUser;
    String tokenInvalido = "tokenInvalido";

    private static final String PRODUTOS = "/produtos";
    private static final String PRODUTOS_ID = PRODUTOS+"/{_id}";

    public ProdutoClient() {}

    public Response cadastrarProduto(Produto produto) {
        tokenAdmin = auth.tokenAdmin();

        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .header("Authorization", tokenAdmin)
                        .body(produto)
                .when()
                        .post(PRODUTOS)
                ;
    }

    public Response cadastrarProdutoSemTokenValido(Produto produto) {
        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .header("Authorization", tokenInvalido)
                        .body(produto)
                        .when()
                        .post(PRODUTOS)
                ;
    }

    public Response cadastrarProdutoSemPermissao(Produto produto) {
        tokenUser = auth.tokenUser();

        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .header("Authorization", tokenUser)
                        .body(produto)
                .when()
                        .post(PRODUTOS)
                ;
    }

    public Response atualizarProduto(String id, Produto produto) {
        tokenAdmin = auth.tokenAdmin();
        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                        .header("Authorization", tokenAdmin)
                        .body(produto)
                .when()
                        .put(PRODUTOS_ID)
                ;
    }

    public Response atualizarProdutoSemTokenValido(String id, Produto produto) {
        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                        .header("Authorization", tokenInvalido)
                        .body(produto)
                        .when()
                        .put(PRODUTOS_ID)
                ;
    }

    public Response atualizarProdutoSemPermissao(String id, Produto produto) {
        tokenUser = auth.tokenUser();
        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                        .header("Authorization", tokenUser)
                        .body(produto)
                        .when()
                        .put(PRODUTOS_ID)
                ;
    }

    public Response buscarProdutoPorId(String id) {

        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                .when()
                        .get(PRODUTOS_ID)
                ;
    }

    public Response buscarTodosProdutos() {

        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                .when()
                        .get(PRODUTOS)
                ;
    }

    public Response buscarTodosProdutosComFiltroNome (String nome) {
        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .queryParam("nome", nome)
                .when()
                        .get(PRODUTOS)
                ;
    }

    public Response deletarProduto(String id) {
        tokenAdmin = auth.tokenAdmin();

        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                        .header("Authorization", tokenAdmin)
                .when()
                        .delete(PRODUTOS_ID)
                ;
    }
    public Response deletarProdutoSemPermissao(String id) {
        tokenUser = auth.tokenUser();

        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                        .header("Authorization", tokenUser)
                        .when()
                        .delete(PRODUTOS_ID)
                ;
    }

    public Response deletarProdutoSemTokenValido(String id) {
        return
                given()
                        .spec(ProdutoSpecs.produtoReqSpec())
                        .pathParam("_id", id)
                        .header("Authorization", tokenInvalido)
                        .when()
                        .delete(PRODUTOS_ID)
                ;
    }

}
