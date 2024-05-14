package Z_07_lecture_query_parameter;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_query_parameter {
	
	@Test
	public void test01() {
		//get reqyuest specification for given request
		RequestSpecification requestSpec= RestAssured.given();
		
		
		//specify uri
		requestSpec.baseUri("https://reqres.in");
		
		//specify basepath
		requestSpec.basePath("/api/users");
		
		//add query param
		requestSpec.queryParam("page", 2).queryParam("id", 10);
		
		
		//perform get request
		Response response=requestSpec.get();
		
		//read response Body
		String responseBodyString=response.getBody().asString();		
		System.out.println("response Body: "+responseBodyString);
		
		JsonPath jsonView=response.jsonPath();
		
		String fname=jsonView.get("data.first_name");
		
		Assert.assertEquals(fname, "Byron","check name is json path");
		
	}

}
