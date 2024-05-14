package Z_13_lecture_query_retrive_requestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class X_01_RequestSpecifications {
	
	@Test
	public void createUser() {
		// create json data
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Brew");
		jsonObject.put("job", "SDET");
		
		// create request using RequestSpecification interface
		RequestSpecification requestSpec = RestAssured.given();
		
		// specify URL
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users"); // Corrected base path for creating a user
		
		requestSpec
			.contentType(ContentType.JSON)
			.body(jsonObject.toJSONString())
			.header("header 1", "  header value");
		
		// query details from request specifications
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(requestSpec);
		
		// get base path
		String retrieveBaseUri = queryRequest.getBaseUri();
		String retrieveBasePath = queryRequest.getBasePath();
		
		// get body
		System.out.println("Base URI: " + retrieveBaseUri);
		System.out.println("Base path: " + retrieveBasePath);
		
		System.out.println("------------------------Request Hedader-------------------------");
		// get headers
		Headers requestHeaders = queryRequest.getHeaders();
		for (Header h : requestHeaders) {
			System.out.println("Header Name: "+h.getName() +"   Header value: "+h.getValue());
		}
		
		
	}
}
