package client;

import io.restassured.response.Response;
import model.Usuario;
import specs.UsuarioSpecs;

import static io.restassured.RestAssured.*;

public class UsuarioClient {

    private static final String USUARIOS = "/usuarios";
    private static final String USUARIOS_ID = "/usuarios/{_id}";

    public UsuarioClient() {}

    public Response cadastrarUsuario(Usuario usuario) {

        return
                given()
                        .spec(UsuarioSpecs.usuarioReqSpec())
                        .body(usuario)
                .when()
                        .post(USUARIOS)
                ;
    }

    public Response atualizarUsuario(String id, Usuario usuario) {

        return
                given()
                        .spec(UsuarioSpecs.usuarioReqSpec())
                        .pathParam("_id", id)
                        .body(usuario)
                .when()
                        .put(USUARIOS_ID)
                ;
    }

    public Response buscarUsuarioPorId(String id) {

        return
                given()
                        .spec(UsuarioSpecs.usuarioReqSpec())
                        .pathParam("_id", id)
                .when()
                        .get(USUARIOS_ID)
                ;
    }

    public Response buscarTodosUsuarios() {

        return
                given()
                        .spec(UsuarioSpecs.usuarioReqSpec())
                .when()
                        .get(USUARIOS)
                ;
    }

    public Response deletarUsuario(String id) {

        return
                given()
                        .spec(UsuarioSpecs.usuarioReqSpec())
                        .pathParam("_id", id)
                .when()
                        .delete(USUARIOS_ID)
                ;
    }

}
