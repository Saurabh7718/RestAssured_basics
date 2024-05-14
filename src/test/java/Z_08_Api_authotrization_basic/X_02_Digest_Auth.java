package Z_08_Api_authotrization_basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_02_Digest_Auth {
	@Test
	public void BasicAuthPreEmptive() {
		RequestSpecification requestSpec=RestAssured.given();
		 
		
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/prachi/prachi");
		
		Response response=requestSpec.auth().digest("prachi", "prachi").get();
		
		System.out.println("Digest auth response body"+ response.body().asPrettyString());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}

}
