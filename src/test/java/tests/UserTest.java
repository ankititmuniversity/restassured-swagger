package tests;

import org.testng.annotations.Test;

import endpoints.UserEndpoint;
import io.restassured.response.Response;
import payloads.UserPayload;

import static io.restassured.RestAssured.*; 
import utils.ReqSpecBuilder;
import utils.ResSpecBuilder;
import java.io.File;
import static org.hamcrest.Matchers.*;


public class UserTest {
	
	File data = new File("src/test/resources/testdata/user_data.json");
    @Test
    public void testCreateUserWithArray() {
     Response response = UserEndpoint.createUserWithArray(data);
     
     response.then()
			.statusCode(200)
			.body("code", equalTo(200))
			.body("type", equalTo("unknown"))
			.body("message", equalTo("ok"));
     System.out.println(response.asPrettyString());
    }
    @Test(dependsOnMethods="testCreateUserWithArray")
    public void getUser() {
     Response response = UserEndpoint.getUser("mohanrajput");  
     
     UserPayload up = response.then()
     .statusCode(200) 
     .contentType("application/json")

     //Exact value checks
     .body("id", equalTo(2))
     .body("username", equalTo("mohanrajput"))
     .body("firstName", equalTo("Mohan"))
     .body("lastName", equalTo("Rajput"))
     .body("email", equalTo("mohan.rajput@example.com"))
     .body("password", equalTo("Mohan@123"))
     .body("phone", equalTo("9123456780"))
     .body("userStatus", equalTo(0))

     //Type checks
     .body("id", instanceOf(Integer.class))
     .body("username", instanceOf(String.class))
     .body("email", instanceOf(String.class))
     .body("userStatus", instanceOf(Integer.class))

     //String checks
     .body("username", startsWith("mohan"))
     .body("firstName", equalToIgnoringCase("mohan"))
     .body("lastName", containsString("Raj"))
     .body("email", containsString("@example.com"))
     .body("password", containsString("@123"))
     .body("phone", hasLength(10)) 
     
     // custom matcher or regex
     .body("email", matchesPattern("^[A-Za-z0-9+_.-]+@(.+)$"))
     .body("phone", matchesPattern("^[0-9]{10}$"))

     //Value/range checks
     .body("id", greaterThan(0))
     .body("userStatus", lessThanOrEqualTo(1))

     //Null / not-null checks
     .body("username", notNullValue())
     .body("email", notNullValue())
     .body("password", notNullValue())
     .extract().as(UserPayload.class);
   
    
     System.out.println("******"+response.asPrettyString()+"*******");
     System.out.println("******"+up.getUsername()+"*******");
     System.out.println("******"+up.getFirstName()+"*******");
     System.out.println("******"+up.getLastName()+"*******");
    }
}
