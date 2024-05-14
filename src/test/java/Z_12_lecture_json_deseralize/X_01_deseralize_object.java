package Z_12_lecture_json_deseralize;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import Z_12_lecture_json_deseralize.X_02_JSON_POST_request_Response;

public class X_01_deseralize_object {
	@Test
	public void deserialize() {
		//create request Specification
		RequestSpecification requestSpec=RestAssured.given();
		
		//specify url
		
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		
		//create request Body
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("name", "flash");
		jsonObject.put("job", "SDET");
		
		//perfrom POST request
		
		Response response=requestSpec
		.contentType(ContentType.JSON)
		.body(jsonObject.toJSONString())
		.post();
		
		ResponseBody responseBody=response.getBody();
		
		//deserealize response body i.e conversion of json data to object data
		
		//Class<T> is a generic form od any class of type T which is also referred as template class
		X_02_JSON_POST_request_Response responseClass=responseBody.as(X_02_JSON_POST_request_Response.class);
		
		System.out.println(responseClass.name);
	}

}
