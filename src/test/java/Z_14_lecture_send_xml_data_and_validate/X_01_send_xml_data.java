package Z_14_lecture_send_xml_data_and_validate;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import org.hamcrest.*;

public class X_01_send_xml_data {
	@Test
	public void adequateShopApiSwaggerApi() {
		//'http://restapi.adequateshop.com/api/Traveler?page=1'

		//create request specifications
		RequestSpecification requestSpec=RestAssured.given(); 

		//specify url
		//https://petstore.swagger.io/#/pet/addPet
		requestSpec.baseUri("http://restapi.adequateshop.com");
		requestSpec.basePath("/api/Traveler");
		
		//add query param
		requestSpec.queryParam("page", "1");

		requestSpec.header("accept","application/xml");
		
		Response response=requestSpec.get();
		response.prettyPrint();
		
		//approach 1  (hamcrest framework)
		response.then().body("TravelerinformationResponse.travelers.Travelerinformation[2].name",Matchers.equalTo("vano"));
				
		
		//approach 2
		

		XmlPath objXmlPath=new XmlPath(response.asString());
		
		String name1=objXmlPath.get("TravelerinformationResponse.travelers.Travelerinformation[2].name");
		String name2=objXmlPath.get("TravelerinformationResponse.travelers.Travelerinformation[0].name");
		
		Assert.assertEquals(name1,"vano");
		Assert.assertEquals(name2,"Developer");
		
		//verify per  total page traveler information should be 10
		
		List<String> listOfTravellers=objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
		int totalTravellerCount=listOfTravellers.size();
		
		Assert.assertEquals(totalTravellerCount, 10);
		
		
		//verify for name vano in travellers list
		List<String> listOfTravellerName=objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		//print all the names in the travellers list
		boolean found=false;
		for(String traveller:  listOfTravellerName) {
			if (traveller.equals("vano")) {
				found=true;
				break;
			}
		}
		Assert.assertEquals(found, true);
	}


	@Test(enabled=false)
	public void sendXmlDataSwaggerpetStore() {
		String jsonData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";


		//create request specifications
		RequestSpecification requestSpec=RestAssured.given(); 

		//specify url
		//https://petstore.swagger.io/#/pet/addPet
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");

		requestSpec.header("accept","application/xml");
		requestSpec.header("Content-Type","application/json"); //we are passing data in form of json
		requestSpec.body(jsonData);


		Response response=requestSpec.post();

		//verify response code
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.statusCode(),200);


		response.then().body("Pet.name", Matchers.equalTo("doggie"));

	}

}
