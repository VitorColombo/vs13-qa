package client;

import io.restassured.response.Response;
import model.Login;
import specs.AuthSpecs;

import static io.restassured.RestAssured.given;

public class AuthClient {

    private static final String LOGIN = "/login";

    public AuthClient() {}

    public Response login(Login login) {

        return
                given()
                        .spec(AuthSpecs.authReqSpec())
                        .body(login)
                        .when()
                        .post(LOGIN)
                ;
    }

}
