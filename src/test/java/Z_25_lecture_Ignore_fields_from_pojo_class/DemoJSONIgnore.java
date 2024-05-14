package Z_25_lecture_Ignore_fields_from_pojo_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class DemoJSONIgnore {
	@Test(enabled=true)
	public void testMethod1() throws JsonProcessingException {

		Employee_PoJo_class emp1=new Employee_PoJo_class();

		emp1.setFullName("suresh mehra");
		emp1.setFirstName("suresh");

		emp1.setLastName("mehra");

		emp1.setGender("male");

		emp1.setAge(29);

		emp1.setMarried(false);

		emp1.setSalary(100000);


		//convert into class object to json payload 
		ObjectMapper objectMapper =new ObjectMapper();

		String emp1String=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);



		System.out.println(emp1String);

		System.out.println("---------------------deserialization--------------------");
		//payload string to employee class object
		String payload="\"firstName\" : \"suresh\",\r\n"
				+ "  \"lastName\" : \"mehra\",\r\n"
				+ "  \"gender\" : \"male\",\r\n"
				+ "  \"age\" : 29,\r\n"
				+ "  \"salary\" : 100000.0,\r\n"
				+ "  \"fullName\" : \"suresh mehra\",\r\n"
				+ "  \"hobbies\" : null,\r\n"
				+ "  \"degrees\" : null,\r\n"
				+ "  \"familyMemberes\" : null,\r\n"
				+ "  \"married\" : false";

		Employee_PoJo_class emp2=objectMapper.readValue(emp1String, Employee_PoJo_class.class);
		System.out.println(emp2.getFullName());
		System.out.println(emp2.getFirstName());
		System.out.println(emp2.getLastName());
		System.out.println(emp2.getAge());
		System.out.println(emp2.getGender());
		System.out.println(emp2.getSalary());
	}
}
