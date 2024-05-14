package Z_15_lecture_create_JSON_Object_using_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class X_01_Manioulation_using_Map {

	@Test(enabled=false)
	public void createAuthToken() {
		//create JSON object using Java Map
		
		Map<String,String> authToken=new HashMap<String,String>();
		
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		
		Response response=RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/auth")
				.contentType("application/json")  //or .contentType(ContentType.JSON) both are same
				.body(authToken)
				.post();
		
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200,"check reuqst type");
	}
	

	@Test
	public void createUserInfo() {
		 /*{
    "isMarried": true,
    "firstName": "amod",
    "lastName": "mahajan",
    "TechSkills": {
        "WebAutomation": "Selenium",
        "programming language": "Java",
        "API testing": "Rest Assured"
    },
    "salary": 1000000,
    "Hobbies": [
        "Music",
        "Games",
        "Computer"
    ],
    "age": 28,
    "id": "633",
    "createdAt": "2024-04-20T12:01:52.318Z"
}
*/
		
		Map<String,Object> info=new HashMap<String,Object>();
		info.put("firstName", "amod");
		info.put("lastName", "mahajan");
		info.put("age", 28);
		info.put("salary", 1000000);
		info.put("isMarried", true);
		
		ArrayList<String> hobbies=new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("Games");
		hobbies.add("Computer");
		
		info.put("Hobbies", hobbies);
		
		
		Map<String,Object> skills=new HashMap<String,Object>();
		skills.put("programming language", "Java");
		skills.put("WebAutomation", "Selenium");
		skills.put("API testing", "Rest Assured");
		
		info.put("TechSkills", skills);
		
		Response response=RestAssured
		.given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(info)
			.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201);
	}
	
	
}
