package Z_22_create_nestedd_json_object;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class X_01_nested_json_object {
/*{
  "firstName" : "suresh",
  "lastName" : "mehra",
  "gender" : "male",
  "age" : 28,
  "salary" : 100000.0,
  "address" : {
    "street" : "andra pradesh",
    "city" : "vijaywada",
    "state" : "park avenue",
    "pincode" : 530012
  }
}
*/
	
	
	@Test
	public void createNestedJSONObject() throws JsonProcessingException {
		X_02_employee_json emp1 =new X_02_employee_json();
		emp1.setFirstName("suresh");
		emp1.setLastName("mehra");
		emp1.setGender("male");
		emp1.setAge(28);
		emp1.setSalary(100000);
		 
		
		X_03_employee_address emp1Address =new X_03_employee_address();
		emp1Address.setCity("vijaywada");
		emp1Address.setState("park avenue");
		emp1Address.setPincode(530012);
		emp1Address.setStreet("andra pradesh");
		
		emp1.setAddress(emp1Address);
		
		//convert class object to json object
		ObjectMapper objectMapper=new ObjectMapper();
		
		String emp1Json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		
		System.out.println(emp1Json);
		
		//perform post request
		
		RequestSpecification reqSpec=RestAssured.given();
		//specify base url
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(emp1Json);
		Response response=reqSpec.post();
		
		
		ResponseBody resBody=response.getBody();
		String resBodyString=resBody.asString();
		
		JsonPath jsonPath=resBody.jsonPath();
		
		String street=jsonPath.get("address.street");
		System.out.println(street);
	}
}
