package Z_21_lecture_pojoClassOfJSOnArray;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class X_01_create_pojo_class_of_json_array {
	@Test
	public void pojoClass() throws JsonProcessingException {
		//create first employee object
		X_02_employee_class emp1=new  X_02_employee_class();

		//create second employee object
		X_02_employee_class emp2=new  X_02_employee_class();

		//create third employee object
		X_02_employee_class emp3=new  X_02_employee_class();


		//assign values for first employee object
		emp1.setFirstName("suresh");
		emp1.setLastName("mehra");
		emp1.setGender("male");
		emp1.setSalary(100000);
		emp1.setAge(31);

		//assign values for second employee object
		emp2.setFirstName("ram");
		emp2.setLastName("singh");
		emp2.setGender("male");
		emp2.setSalary(34000);
		emp2.setAge(30);



		//assign values for third employee object

		emp3.setFirstName("sita");
		emp3.setLastName("gupta");
		emp3.setGender("female");
		emp3.setSalary(39000);
		emp3.setAge(28);
		
		
		//create list of employee
		
		List<X_02_employee_class> listOfEmp=new ArrayList<X_02_employee_class>();
		
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		
		//convert employee class object to json array payload as a string(serialization)
		ObjectMapper objectMapper=new ObjectMapper();
		
		String listOfEmpString=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		
		//System.out.println(listOfEmpString);
		
		
		//create requestSpecification
		RequestSpecification reqSpec=RestAssured.given();
		
		//create url
		reqSpec.baseUri("https://httpbin.org/post");
		//reqSpec.baseUri("https://reqres.in/api/users");

		reqSpec.header("Content-Type", "application/json");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(listOfEmpString);
		
		Response response=reqSpec.post();
		
		
		
		
		System.out.println("------------------------response body---------------------------------");
		
		response.prettyPrint();
		
		
		//verify status code
		Assert.assertEquals(response.statusCode(), 200, "check for operation");
		
		
		//covert json object array to employee class object
		//deserialization
		
		System.out.println("----------------------deserialization-------------------------------");
		ResponseBody responseBody=response.getBody();
		JsonPath jsonPath=responseBody.jsonPath();
		
		//we need to traverse to json object
		
		List<X_02_employee_class> allEmployee=jsonPath.getList("json",X_02_employee_class.class);
		
		for(X_02_employee_class emp:allEmployee) {
			System.out.println(emp.getFirstName());
			
		}
		
 		
		
		
		
	}

}
