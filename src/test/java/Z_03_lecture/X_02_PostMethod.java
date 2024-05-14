package Z_03_lecture;
import org.json.simple.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class X_02_PostMethod {
	@Test
	public void test03() {
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "Prachi");
		jsonData.put("job", "QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured
		.given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.body(jsonData.toJSONString())
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all();
	}

}
