package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class ResSpecBuilder {

    private static ResponseSpecification res_spec;

    public static ResponseSpecification getResponseSpec() {
        if (res_spec == null) {
            res_spec = new ResponseSpecBuilder()        
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                    .expectHeader("access-control-allow-headers", "Content-Type, api_key, Authorization")
                    .expectHeader("access-control-allow-methods", "GET, POST, DELETE, PUT")
                    .expectHeader("access-control-allow-origin", "*")
                    .expectHeader("server", "Jetty(9.2.9.v20150224)")
                    .expectBody("code", equalTo(200))
                    .expectBody("type", equalTo("unknown"))
                    .expectBody("message", equalTo("ok"))
                    .expectResponseTime(lessThan(5000L))
                    .build();
        }
        return res_spec;
    }
}
