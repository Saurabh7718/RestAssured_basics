package Z_20_lecture_POJO;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_02_searialization_and_deserialization {

	@Test
	public void createJSONObjectFromEmployeeClassObject() throws JsonProcessingException {
		X_01_employee emp1=new X_01_employee();
		
		emp1.setFirstName("suresh");
		emp1.setLastName("mehra");
		emp1.setGender("male");
		emp1.setAge(23);
		emp1.setSalary(100000);
		
		//convert employee class object to json payload as string

		ObjectMapper objMapper=new ObjectMapper();
		
		String employeeJSON=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		//System.out.println(employeeJSON);
		
		RequestSpecification requestSpec=RestAssured.given();
		
		requestSpec.baseUri("https://httpbin.org/post");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(employeeJSON);
		Response response=requestSpec.post();
		
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200,"check for status code");
		
		
	
		System.out.println("---------------------------- deseariliazation----------------------------");
		//convert JSON string to class object employee class objet
		
		X_01_employee emp2=objMapper.readValue(employeeJSON, X_01_employee.class);
		
		System.out.println(emp2.getFirstName());
		System.out.println(emp2.getLastName());
		System.out.println(emp2.getAge());
		System.out.println(emp2.getGender());
		System.out.println(emp2.getSalary());
		
	}
	
}
