package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class InicialSpecs {
    private InicialSpecs() {}

    public static RequestSpecification setup(int port) {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(port)
                .build();
    }
}
