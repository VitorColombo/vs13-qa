package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AuthSpecs {

    private AuthSpecs() {}
    public static RequestSpecification authReqSpec() {
        return new RequestSpecBuilder()
                .addRequestSpecification(InicialSpecs.setup())
                .setContentType(ContentType.JSON)
                .build();
    }
}
