package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UsuarioSpecs {
    private static int port = 3000;

    private UsuarioSpecs() {}

    public static RequestSpecification usuarioReqSpec() {
        return new RequestSpecBuilder()
                .addRequestSpecification(InicialSpecs.setup(port))
                .setContentType(ContentType.JSON)
                .build();
    }

}
