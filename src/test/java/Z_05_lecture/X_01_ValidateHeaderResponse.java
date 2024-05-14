package Z_05_lecture;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_ValidateHeaderResponse {
	
	@Test
	public void getSingleUser() {
		//get request specification
		RequestSpecification requestSpec=RestAssured.given();
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
		//specify basepath
		requestSpec.basePath("/api/users/2");
		
		
		//create get request
		Response response=requestSpec.get();
		
		//validate response header
		String contentType=response.getHeader("Content-Type");
		String connection=response.getHeader("Connection");
		
		//System.out.println("contentType :"+contentType);
		//System.out.println("Connection : "+connection);
		
		//read alll the response header attribute/keys and print their values
		Headers headersList=response.getHeaders();
		
		//iterate header list
		//for(Header header: headersList ) {
		//	System.out.println(header.getName() +" : "+ header.getValue());
		//}
		
		//validate header contetn type, expected value  application/json; charset=utf-8
		Assert.assertEquals(contentType, "application/json; charset=utf-8", "header contenttype mismatch");
		
		
		
	
	}
	
	
	

}
