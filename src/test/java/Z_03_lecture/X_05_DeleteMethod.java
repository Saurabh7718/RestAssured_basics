package Z_03_lecture;

import org.testng.annotations.Test;

import io.restassured.RestAssured;import io.restassured.http.ContentType;

public class X_05_DeleteMethod {
	@Test
	public void test06() {
		
		RestAssured.baseURI="https://reqres.in/api/users/562";
		RestAssured
		.given()
		.when().delete()
		.then().statusCode(204)
		.log().all();
		
	}

}
