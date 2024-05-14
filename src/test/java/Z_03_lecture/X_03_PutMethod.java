package Z_03_lecture;

import org.json.simple.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class X_03_PutMethod {
	
	@Test
	public void test04() {
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "saurabh");
		jsonData.put("job", "SDET");
		
		RestAssured.baseURI="https://reqres.in/api/users/562";
		
		RestAssured
		.given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.body(jsonData.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
			
				
	}

}
