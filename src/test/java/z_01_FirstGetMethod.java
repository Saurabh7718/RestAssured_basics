 
import org.testng.annotations.Test;
import io.restassured.response.*;
import io.restassured.RestAssured;

public class z_01_FirstGetMethod {
	//https://reqres.in/api/users/2
	
	@Test
	
	void testCase01() 
	{
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asPrettyString());
		System.out.println("response code:" + res.getStatusCode());  
	}

}
