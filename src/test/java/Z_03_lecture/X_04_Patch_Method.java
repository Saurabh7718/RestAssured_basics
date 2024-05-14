package Z_03_lecture;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class X_04_Patch_Method {
	@Test
	public void test05() {
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "sam");
		jsonData.put("job", "SDET");
		
		RestAssured.baseURI="https://reqres.in/api/users/562";
		
		RestAssured
		.given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.body(jsonData.toJSONString())
		.when()
			.patch()
		.then()
			.statusCode(200)
			.log().all();
			
				
	}
	}


