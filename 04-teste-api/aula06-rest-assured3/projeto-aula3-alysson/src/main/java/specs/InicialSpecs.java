package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class InicialSpecs {

    private InicialSpecs() {}

    public static RequestSpecification setup() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(3000)
                .build();
    }
}
