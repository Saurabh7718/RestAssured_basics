package Z_04_lecture_validate_response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class X_01_CheckForValidResponse {
	//https://reqres.in/api/users/2
	
//	@Test(enabled=false)
//	public void getSingleUser() {
//		//specify base url
//		RestAssured.baseURI="https://reqres.in/api/users/2000";
//		
//		//get request specification of the request
//		RequestSpecification requestSpec=RestAssured.given();
//		
//		//call get method
//		Response response=requestSpec.get();
//		
//		//get response code
//		int statusCode=response.getStatusCode();
//		
//		//validate actual stattus code with expected
//		//actual,expected
//		//Assert.assertEquals(statusCode/*actual status code*/, 200/*expected status code*/);
//		
//		
//		String statusline=response.getStatusLine();
//		Assert.assertEquals(statusline, "HTTP/1.1 200 OK","incorrect status line returned");
//		
//		
//		
//		
//	}
//	
//	@Test(enabled=false)
//	public void getSingleUserValidatableResponse() {
//		//specify base url
//		RestAssured.baseURI="https://reqres.in/api/users/2";
//		
//		//get request specification of the request
//		RequestSpecification requestSpec=RestAssured.given();
//		
//		//call get method
//		Response response=requestSpec.get();
//		
//		ValidatableResponse validateRes=response.then();
//
//		validateRes.statusCode(200);
//		
//		validateRes.statusLine("HTTP/1.1 200 OK");
//		
//		
//		
//	}
	
	@Test
	public void BDDStyle() {
		//specify base url
		//baseURI="https://reqres.in/api/users/2000";
		
	
		given()
		
		
		.when()
			.get("https://reqres.in/api/users/2")
			
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
		
	}

}
