package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ProdutoSpecs {

    private ProdutoSpecs() {}

    public static RequestSpecification produtoReqSpec(int port) {
        return new RequestSpecBuilder()
                .addRequestSpecification(InicialSpecs.setup(port))
                .setContentType(ContentType.JSON)
                .build();
    }
}
