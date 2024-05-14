package Z_27_lecture_generate_mock_api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_mockApiGenerate {
	/*{
"firstName":"suresh",
"lastName":"mehra",
"gender":"male",
"age":28,
"salary":"1000000.0",
"hobbies":[
		"reading",
		"music"
		],
"familyMembers":{
	"1":"Mother",
	"2":"Father",
	},
"married":true
}
	 */

	//https://designger.mocky.io
	//mock api uri: https://run.mocky.io/v3/5b1f8812-79d4-41fd-b880-f4c2762bc4af


	@Test(enabled=true)
	public void test1() {
		RequestSpecification reqSpec=RestAssured.given();

		reqSpec.baseUri("https://run.mocky.io/v3/787de053-4a8d-4436-9e4d-f7b96f37a547");
		Response response=reqSpec.get();

		response.prettyPrint();


		//validate status code to be 200

		Assert.assertEquals(response.statusCode(), 200, "check mock api repsonse code");





	}



	//how to convert JSON object repsonse to POJO classs Object

	@Test
	public void test2() {
		RequestSpecification reqSpec=RestAssured.given();

		reqSpec.baseUri("https://run.mocky.io/v3/787de053-4a8d-4436-9e4d-f7b96f37a547");
		Response response=reqSpec.get();

		//response.prettyPrint();


		//perform get request
		Employee_PoJo_class emp2=reqSpec.get().as(Employee_PoJo_class.class);
		
		System.out.println(emp2.getFirstName());
        System.out.println(emp2.getLastName());
        System.out.println(emp2.getAge());
        System.out.println(emp2.getGender());
        System.out.println(emp2.getSalary());
        
        String[] hobbiesStr=emp2.getHobbies();
        
       for(int i=0;i<hobbiesStr.length;i++){
    	   System.out.println(hobbiesStr[i]);
       }
	}
}