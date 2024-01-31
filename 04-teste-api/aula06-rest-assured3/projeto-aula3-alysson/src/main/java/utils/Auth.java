package utils;

import client.AuthClient;
import model.Login;

public class Auth {
    private static final AuthClient authClient = new AuthClient();

    public static String tokenAdmin() {

        Login loginAdm = new Login(
                Manipulation.getProp().getProperty("emailAdmin"),
                Manipulation.getProp().getProperty("passwordAdmin")
        );

        return authClient.login(loginAdm)
                .then()
                    .extract()
                    .path("authorization")
                ;
    }

    public static String tokenUser() {

        Login login = new Login(
                Manipulation.getProp().getProperty("email"),
                Manipulation.getProp().getProperty("password")
        );

        return authClient.login(login)
                .then()
                .extract()
                .path("authorization")
                ;
    }

}
