package Z_16_lecture_JSON_Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/*
 [
     {
        "firstname": "prachi",
        "salary": "1000000",
        "age": "28",
        "lastname": "gupta"
    },
    {
        "firstname": "prerna",
        "salary": "20000",
        "age": "34",
        "lastname": "gupta"
    },
    {
        "firstname": "jatin",
        "salary": "3000000",
        "age": "36",
        "lastname": "m"
    }
]

*/
public class X_01_createJSON_Array_using_JSON_object {
	@Test
	public void createUsingJSONArray() {
		JSONObject user1=new JSONObject();
		user1.put("firstname", "prachi");
		user1.put("lastname", "gupta");
		user1.put("age", "28");
		user1.put("salary", "1000000");
		
		JSONObject user2=new JSONObject();
		user2.put("firstname", "prerna");
		user2.put("lastname", "gupta");
		user2.put("age", "34");
		user2.put("salary", "20000");
		
		JSONObject user3=new JSONObject();
		user3.put("firstname", "jatin");
		user3.put("lastname", "m");
		user3.put("age", "36");
		user3.put("salary", "3000000");
		
		//add json objects to json array
		JSONArray userPayLoad=new JSONArray();
		userPayLoad.add(user1);
		userPayLoad.add(user2);
		userPayLoad.add(user3);
		
		
		RequestSpecification requestSpec=RestAssured.given();
		
		requestSpec.basePath("/api/users");
		requestSpec.baseUri("https://reqres.in");
		
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(userPayLoad);
		
		Response response =requestSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201, "check request");
	}

}
