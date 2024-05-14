package Z_09_lecture_bearer_token;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_bearer_token {

	@Test
	public void test01() {
		//create request specification
		
		RequestSpecification requestSpec=RestAssured.given();
		
		//https://gorest.co.in/public/v2/users
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		//Bearer c70b627730547dedd56adb0958a7e4ebb40a9b826311999dab604232ad8bc06e

		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "sam123");
		jsonObject.put("gender", "male");
		jsonObject.put("email", "sam123@gmail.com");
		jsonObject.put("status", "active");
		
		String AuthToken="Bearer c70b627730547dedd56adb0958a7e4ebb40a9b826311999dab604232ad8bc06e";
		
		requestSpec
			.header("Authorization", AuthToken)
			.contentType(ContentType.JSON)
			.body(jsonObject.toJSONString());
		
		
		Response response=requestSpec.post();
		
		Assert.assertEquals(response.statusCode(), 201, "check request type");
		
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());
		
	}

}
