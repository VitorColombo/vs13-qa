package produtos;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProdutosFuncionalTest {
    private String token;
    private String password = "asd";
    private String email = "asd";
    private String idProduto;

    @BeforeEach
    public void setUp() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testCadastrarProdutoComSucesso() {
        logarAdmin();

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA S4",
                          "preco": 100,
                          "descricao": "Celularzao edicao limitada",
                          "quantidade": 10
                        }
                        """)
                .header("Authorization", token)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(201)
        ;
    }

    @Test
    public void testBuscarProdutoPorIDComSucesso() {
        logarAdmin();

        given()
                .log().all()
                .pathParam("_id", idProduto)
        .when()
                .get("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("_id", notNullValue())
        ;
    }

    @Test
    public void testListarProdutosCadastradosComSucesso() {

        given()
                .log().all()
        .when()
                .get("/produtos")
        .then()
                .log().all()
                .statusCode(200)
                .body("produtos", hasSize(greaterThan(0)))
        ;
    }

    @Test
    public void testEditarProdutoComSucesso() {
        logarAdmin();

        given()
                .log().all()
                .pathParam("_id", idProduto)
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA SSS",
                          "preco": 100,
                          "descricao": "celular fulero a rodo",
                          "quantidade": 10
                        }
                        """)
                .header("Authorization", token)
        .when()
                .put("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testExcluirProdutosComSucesso() {
        logarAdmin();

        given()
                .log().all()
                .pathParam("_id", idProduto)
                .header("Authorization", token)
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }

    @Test
    public void testCadastrarProdutoSemToken() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA",
                          "preco": 100,
                          "descricao": "Celularzao edicao limitada",
                          "quantidade": 10
                        }
                        """)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(401)
        ;
    }

    @Test
    public void testBuscarProdutoPorIDcomIDinvalido() {
        String idProdutoInvalido = "aasdasdasd";
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
                .body("message", equalTo("Produto não encontrado"))
        ;
    }

    @Test
    public void testEditarProdutoSemToken() {
        idProduto = "X2Hrg2oDeoe8JKVX";
        given()
                .log().all()
                .pathParam("_id", idProduto)
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA",
                          "preco": 100,
                          "descricao": "celular fulero a rodo",
                          "quantidade": 10
                        }
                        """)
        .when()
                .put("/produtos/{_id}")
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(1000L))
                .statusCode(401)
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))        ;
    }

    @Test
    public void testExcluirProdutosSemToken() {
        idProduto = "X2Hrg2oDeoe8JKVX";
        given()
                .log().all()
                .pathParam("_id", idProduto)
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(1000L))
                .statusCode(401)
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))        ;
        ;
    }

    @Test
    public void testCadastrarProdutoSemPermissao() {
        logar();
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA",
                          "preco": 100,
                          "descricao": "Celularzao edicao limitada",
                          "quantidade": 10
                        }
                        """)
                .header("Authorization", token)
        .when()
                .post("/produtos")
        .then()
                .log().all()
                .statusCode(403)
                .body("message", equalTo("Rota exclusiva para administradores"))
        ;
    }

    @Test
    public void testEditarProdutoSemPermissao() {
        logar();

        given()
                .log().all()
                .pathParam("_id", idProduto)
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "nome": "Smartphone Positivo S66 ULTRA",
                          "preco": 100,
                          "descricao": "celular fulero a rodo",
                          "quantidade": 10
                        }
                        """)
                .header("Authorization", token)
        .when()
                .put("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(403)
                .body("message", equalTo("Rota exclusiva para administradores"))
        ;
    }

    @Test
    public void testExcluirProdutosSemPermissao() {
        logar();

        given()
                .log().all()
                .pathParam("_id", idProduto)
                .header("Authorization", token)
        .when()
                .delete("/produtos/{_id}")
        .then()
                .log().all()
                .statusCode(403)
                .body("message", equalTo("Rota exclusiva para administradores"))
        ;
    }

    @Test
    public void testBuscarProdutoPorIDComIDInvalido() {
        logar();

        given()
                .log().all()
                .pathParam("_id", 123412312)
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

        given()
                .log().all()
                .queryParam("nome", "Smartphone Positivo S66 ULTRA")
        .when()
                .get("/produtos")
        .then()
                .log().all()
                .statusCode(200)
                .body("produtos", hasSize(greaterThan(0)))
                .body("produtos.findAll{it.nome.contains('Smartphone Positivo S66 ULTRA')}.nome", hasItem("Smartphone Positivo S66 ULTRA"))
                .time(lessThan(1000L))
        ;
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

    private void logarAdmin(){
        email = "alyson.pesqueira@qa.com.br";
        password = "teste";
        idProduto = "ysF6XicSCySBoaXq";
        login(email, password);
    }

    private void logar(){
        email = "fgf@qa.com.br";
        password = "teste";
        idProduto = "ysF6XicSCySBoaXq";
        login(email, password);
    }

}
