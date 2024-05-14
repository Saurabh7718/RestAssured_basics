package Z_24_lecture_jsoninclude_annotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class demoJSONInclude {

	@Test(enabled=true)
	public void testMethod1() throws JsonProcessingException {

		//create payload
		//this case is used when we dont want to see values containing null, 0,false values
		//we comment out some values but due to pojo class values will be shown for test metod by using annotation
		//on pojo class we can exclude some properties
		employeePoJoClass emp1=new employeePoJoClass();

		emp1.setFirstName("suresh");

		//emp1.setLastName("mehra");

		emp1.setGender("male");

		//emp1.setAge(29);

		emp1.setMarried(false);

		//emp1.setSalary(100000);

//hobbies
		String[] hobbies= {};
		
		emp1.setHobbies(hobbies);
		
		//empty list
		
		List<String >degrees=new ArrayList<String>();
		emp1.setDegrees(degrees);
		
		//empty map
		Map<String,String> familyMembers=new HashMap<String,String>();
		
		emp1.setFamilyMemberes(familyMembers);
		
		ObjectMapper objectMapper =new ObjectMapper();

		String emp1String=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

		
		
		System.out.println(emp1String);


	}


	@Test(enabled=false)
	public void testMethod2() throws JsonProcessingException {

		//create payload
		//remove only null values

		employeePoJoClass emp1=new employeePoJoClass();

		emp1.setFirstName("suresh");

		//emp1.setLastName("mehra");

		emp1.setGender("male");

		//emp1.setAge(29);

		emp1.setMarried(false);

		//emp1.setSalary(100000);


		ObjectMapper objectMapper =new ObjectMapper();

		String emp1String=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

		System.out.println(emp1String);
	}

}
