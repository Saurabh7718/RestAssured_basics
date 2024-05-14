package Z_16_lecture_JSON_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_02_create_json_array_using_listORSet {

	@Test
	public void createUSerusingJSONArrayUsingList() {

		Map<String, Object> user1 = new HashMap<String, Object>();
		user1.put("firstname", "prachi");
		user1.put("lastname", "gupta");
		user1.put("age", "28");
		user1.put("salary", "1000000");

		Map<String, Object> user2 = new HashMap<String, Object>();
		user2.put("firstname", "prerna");
		user2.put("lastname", "gupta");
		user2.put("age", "34");
		user2.put("salary", "20000");

		Map<String, Object> user3 = new HashMap<String, Object>();
		user3.put("firstname", "jatin");
		user3.put("lastname", "m");
		user3.put("age", "36");
		user3.put("salary", "3000000");

		// create json array using list
		List<Map<String, Object>> userPayLoad = new ArrayList<Map<String, Object>>();

		userPayLoad.add(user1);
		userPayLoad.add(user2);
		userPayLoad.add(user3);

		RequestSpecification requestSpec = RestAssured.given();

		requestSpec.basePath("/api/users");
		requestSpec.baseUri("https://reqres.in");

		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(userPayLoad);
		
		Response response=requestSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201);
		
	}

}
