package methods;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

import org.apache.http.HttpStatus;
import org.junit.Test;

import io.restassured.http.ContentType;

public class PostMethods {

	@Test
	public void RegisterNewUser() {

		baseURI = "https://reqres.in";

		String requestBody = "{\n" + " \"email\": \"eve.holt@reqres.in\",\n" + " \"password\": \"pistol\"\n" + "}";
				
		given().log().all().contentType(ContentType.JSON).body(requestBody).when().post("/api/register").then().log()
				.body().statusCode(HttpStatus.SC_OK).body("$", hasKey("token"));

	
	
	}

	
	
}
