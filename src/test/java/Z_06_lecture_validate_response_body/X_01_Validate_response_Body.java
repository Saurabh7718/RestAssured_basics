package Z_06_lecture_validate_response_body;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class X_01_Validate_response_Body {
	
	@Test
	public void test01() {
		//https://reqres.in/api/users?page=2
		
		//Get requestSpecification reference
		RequestSpecification requestSpec=RestAssured.given();
		
		//specify base 
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=2");
		
		//create get request
		Response response=requestSpec.get();
		
		
		//read response body
		
		ResponseBody responseBody=response.getBody();
		
		//rsponsebofy convert into string
		//String responseString=responseBody.asString();
		
		//print response body
		//System.out.println("response Body: "+ responseString);

		//check for presence of Geroge in response body
		//Assert.assertTrue(responseString.contains("George"), "Check for the presence of George");
		
		//get json path view of response body
		
		
		JsonPath jsonPathView=responseBody.jsonPath();
	
		//x.data[0].first_name
		
		String firstName=jsonPathView.get("data[0].first_name");
		
		Assert.assertEquals(firstName, "George","check for presence of firstName as michel,FirstaName is not found");
}
}
