package Z_10_Authorization_API_key;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_API_Key {
	
	@Test
	public void GetWeatherDataByCity() {
		//https://api.openweathermap.org/data/2.5/weather?id={city name}&appid={API key}
		
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		
		requestSpec.queryParam("name", "pune").queryParam("appid", "70bc2f90e4fef9a1b22e4349d5c6735b");
		
		Response response=requestSpec.get();
		
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());
	}

}
