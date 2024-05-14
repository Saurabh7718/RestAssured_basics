package Z_30_JSON_schema_Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.io.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class X_01_json_schema_validation {
	@Test
	public void test() {
		String payload="{\r\n"
				+ "    \"username\":\"admin\",\r\n"
				+ "    \"password\":\"password123\"\r\n"
				+ "\r\n"
				+ "}";
		
		RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.contentType(ContentType.JSON)
			.body(payload)
		.when()
			.post()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("token",Matchers.notNullValue())
			.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Lenovo\\Downloads\\schema.json")));
			
	}

}
