package Z_29_responseSpecification_and_responsebuilder;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class X_01_ResponseSpecifications {
	ResponseSpecification responseSpec=null;
	
	@BeforeClass
	public void createResponseSpec() {
		ResponseSpecBuilder responseBuilder=new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectStatusLine("HTTP/1.1 200 OK");
		responseBuilder.expectContentType(ContentType.JSON);
		responseBuilder.expectResponseTime(Matchers.lessThan(3000L));
		
		responseSpec=responseBuilder.build();//assembled response builder share response
		
	}
	
	 
	@Test(enabled=true, priority=1)
	public void getAllBookings() {
	    
	    //url specify
	    RestAssured
	    .given()
	        .baseUri("https://restful-booker.herokuapp.com/") // Removed the extra space after the URL
	    .when()
	        .get("booking") // Removed extra space before the path
	    .then()
	    /*	.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3000L));
	*/
	        .spec(responseSpec)
	        .body("size()", Matchers.greaterThan(0));
	}

	@Test
	public void getBookingsByName() {
	    
	    //url specify
	    RestAssured
	    .given()
	        .baseUri("https://restful-booker.herokuapp.com/") // Removed the extra space after the URL
	    .when()
	        .get("booking/1") // Removed extra space before the path
	    .then()
	    /*	.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3000L));
	*/
	        .spec(responseSpec);
	}

}
