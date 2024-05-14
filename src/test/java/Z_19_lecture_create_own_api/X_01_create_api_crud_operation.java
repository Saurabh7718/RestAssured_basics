package Z_19_lecture_create_own_api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_create_api_crud_operation {

	@BeforeClass
	public void setupDefault() {
		// create request specifiactions
		RequestSpecification requestSpec = RestAssured.given();

		// specify url
		requestSpec.baseUri("http://localhost:3000");
		requestSpec.basePath("/data");

		RestAssured.requestSpecification = requestSpec;
	}

	@Test(enabled = false)
	public void readUserData() {

		// perform get request
		Response response = RestAssured.get();

		// print response body
		response.prettyPrint();

	}

	@Test(enabled = false)
	public void createUserData() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstname", "virat");
		jsonObject.put("lastname", "kohli");
		jsonObject.put("email", "virat@gmail.com");

		Response response = RestAssured.given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.body(jsonObject.toJSONString()).post();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 201);
	}

	@Test(enabled=false)
	public void updateUserData() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstname", "virat");
		jsonObject.put("lastname", "dhoni");
		jsonObject.put("email", "virat@gmail.com");

		Response response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.body(jsonObject.toJSONString())
				.put("/1477");

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200);

	}
	
	@Test
	public void deleteUserData() {

		 
		Response response = RestAssured
				
				.delete("/1477");

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(), 200);

	}
	

}
