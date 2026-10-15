package utils;

import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import routes.CommonRoutes;

public class ReqSpecBuilder {
	private static RequestSpecification req_spec;
	public static RequestSpecification requestBuilder() {

		Map<String,String>headers = new HashMap<>();
		headers.put("accept","application/json");
		headers.put("Content-Type","application/json");

		req_spec =  new RequestSpecBuilder()
				        .addFilter(new RequestLoggingFilter())   
                        .addFilter(new ResponseLoggingFilter())
						.setRelaxedHTTPSValidation()
						.addHeaders(headers)
						.setBaseUri(CommonRoutes.BASE_URI)
						.setBasePath(CommonRoutes.BASE_PATH)
						.build();
											
		return req_spec;
	}
}
