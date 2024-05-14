package Z_08_Api_authotrization_basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_basic_authorization {
	//API Authorization
	//basic authorization
	
	@Test(enabled=false)
	public void BasicAuth() {
		RequestSpecification requestSpec=RestAssured.given();
		//non-pre-emptive authorization
		//specify url
		
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		Response response=requestSpec.auth().basic("postman", "password").get();
		
		System.out.println("response status line "+ response.statusLine());
		
	}
	
	@Test(enabled=true)
	public void BasicAuthPreEmptive() {
		RequestSpecification requestSpec=RestAssured.given();
		//non-pre-emptive authorization
		//specify url
		
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		Response response=requestSpec.auth().preemptive().basic("postman", "password").get();
		
		System.out.println("response   body"+ response.body().asPrettyString());
		
		
	}
	
}
