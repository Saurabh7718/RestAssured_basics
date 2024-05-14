package Z_26_lecture_ignore_unknown_properties_during_deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class DemoJSONIgnoreProperties {
   
	//using @JSONIgnoreProperties
		@Test(enabled = false)
     
        public void testMethod1() throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println("---------------------deserialization--------------------");
            // Payload string to employee class object
            String payload = "{"
                    + "\"firstName\" : \"suresh\",\r\n"
                    + "\"lastName\" : \"mehra\",\r\n"
                    + "\"gender\" : \"male\",\r\n"
                    + "\"age\" : 29,\r\n"
                    + "\"salary\" : 100000.0,\r\n"
                    + "\"fullName\" : \"suresh mehra\"\r\n"
                    + "}";


            Employee_PoJo_class emp2 = objectMapper.readValue(payload, Employee_PoJo_class.class);
           // System.out.println(emp2.getFullName());
            System.out.println(emp2.getFirstName());
            System.out.println(emp2.getLastName());
            System.out.println(emp2.getAge());
            System.out.println(emp2.getGender());
            System.out.println(emp2.getSalary());
        }
    
    
    //if we do not having access to POJO class then we use objectMapper
    @Test
    public void testMethod2() throws JsonProcessingException {
    	
    	
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println("---------------------deserialization--------------------");
        // Payload string to employee class object
        String payload = "{"
                + "\"firstName\" : \"suresh\",\r\n"
                + "\"lastName\" : \"mehra\",\r\n"
                + "\"gender\" : \"male\",\r\n"
                + "\"age\" : 29,\r\n"
                + "\"salary\" : 100000.0,\r\n"
                + "\"fullName\" : \"suresh mehra\"\r\n"
                + "}";


        Employee_PoJo_class emp2 = objectMapper.readValue(payload, Employee_PoJo_class.class);
       // System.out.println(emp2.getFullName());
        System.out.println(emp2.getFirstName());
        System.out.println(emp2.getLastName());
        System.out.println(emp2.getAge());
        System.out.println(emp2.getGender());
        System.out.println(emp2.getSalary());
    }
}
