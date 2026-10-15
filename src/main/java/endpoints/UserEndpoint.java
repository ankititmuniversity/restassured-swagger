package endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.ReqSpecBuilder;
import utils.ResSpecBuilder;

public class UserEndpoint {

	public static Response createUserWithArray(File userpayload) {
		Response response = given()
				.spec(ReqSpecBuilder.requestBuilder())
				.body(userpayload)
				.when()
				.post("createWithArray")
				.then()
				.spec(ResSpecBuilder.getResponseSpec())
				.extract().response();
		return response;
	}

	public static Response getUser(String username) {
		Response response = given()
				.spec(ReqSpecBuilder.requestBuilder())					            
				.when()
				.get(username)
				.then()
				//.spec(ResSpecBuilder.getResponseSpec())
				.extract().response();
		return response;	     

	}
}
