package Z_03_lecture;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class X_01_GetMethod {

    @Test
	
	void test01() 
	{
		Response res=get("https://reqres.in/api/users?page=2");
		 
		System.out.println("Response code:" + res.getStatusCode());
		System.out.println("Response body" + res.getBody().asString());
		System.out.println("Response time:" + res.getTime());
		System.out.println("Header :" + res.getHeader("Content-Type"));
		
		
		//validate status code
		//expected status code=200
		int expectedStatusCode=200;
		int actualStatusCode=res.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
    
    @Test
    //using bdd approach
    void test02() {
    	//Given,when,then
    	baseURI="https://reqres.in/api/users";
    	
    	 
    	given()
    		.queryParam("page", 2)
    	.when()
    		.get()
    	.then()
    		.statusCode(200);
    }
}
