package Z_23_complex_nested_json_object;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Z_22_create_nestedd_json_object.X_03_employee_address;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_04_complex_nested_pojo_class {
	
	@Test
	public void CreateNestedJSONUser() throws JsonProcessingException {
		//create request Payload
		X_01_employee_object requestPayload=new X_01_employee_object();
		
		requestPayload.setCompanyName("XYZ ltd");
		requestPayload.setCity("rk puram delhi");
		requestPayload.setStreet("africa avenue");
		requestPayload.setState("new delhi");
		requestPayload.setPincode("120066");
	
		List<String> bankName=new ArrayList<String>();
		bankName.add("HDFC");
		bankName.add("SBI");
		bankName.add("AXIS");
		
		
		requestPayload.setBankAccount(bankName);
		
		
		
		X_02_nested_employee_json emp1=new X_02_nested_employee_json();
		X_02_nested_employee_json emp2 =new X_02_nested_employee_json();
		X_02_nested_employee_json emp3=new X_02_nested_employee_json();
		
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
		
		
		
		
		emp2.setFirstName("amit");
		emp2.setLastName("gupta");
		emp2.setGender("male");
		emp2.setAge(34);
		emp2.setSalary(200000);

		X_03_employee_address emp2Address =new X_03_employee_address();
		emp2Address.setCity("vijaywada");
		emp2Address.setState("andra pradesh");
		emp2Address.setPincode(530012);
		emp2Address.setStreet("plot 7");
		
		emp2.setAddress(emp2Address);
		
		
		
		
		emp3.setFirstName("ashish");
		emp3.setLastName("das");
		emp3.setGender("male");
		emp3.setAge(35);
		emp3.setSalary(300000);
		

		X_03_employee_address emp3Address =new X_03_employee_address();
		emp3Address.setCity("vijaywada");
		emp3Address.setState("park avenue");
		emp3Address.setPincode(530012);
		emp3Address.setStreet("andra pradesh");
		
		emp3.setAddress(emp3Address);
		
		
		
		List<X_02_nested_employee_json> employeeList=new ArrayList<X_02_nested_employee_json>();
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		
		
		
		requestPayload.setEmployeeList(employeeList);
		
		
		
		//convert class object to json object
		ObjectMapper objectMapper=new ObjectMapper();
		
		
		String requestPayloadJSONFormat=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		
		
		//System.out.println(requestPayloadJSONFormat);
		
		
		
		//create requestSpecification
		
		RequestSpecification reqSpec=RestAssured.given();
		
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(requestPayloadJSONFormat);
		Response response=reqSpec.post();
		
		response.prettyPrint();
		
		//System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 201, "check for baseuri");
	}

}
