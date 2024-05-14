package Z_28_lecture_add_header_in_request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeaderInRequestDemo {
	@Test(enabled=false)
	public void test() {

		RequestSpecification reqSpec=RestAssured.given();

		// 1st approach using key value pair send in headers directly
		//add header 
		reqSpec.header("Header1", "value1");
		reqSpec.log().headers();
		//specify url
		reqSpec.baseUri("https://reqres.in/api/users");
		Response response=reqSpec.get();



	}

	@Test(enabled=false)
	public void test2() {

		RequestSpecification reqSpec=RestAssured.given();

		// 2 nd approach using Map
		//add header 

		Map<String,String> requestHeader=new HashMap<String,String>();
		requestHeader.put("header1", "value1");
		requestHeader.put("header2", "value2");



		reqSpec.headers(requestHeader);
		reqSpec.log().headers();
		//specify url
		reqSpec.baseUri("https://reqres.in/api/users");
		Response response=reqSpec.get();



	}

	@Test(enabled=false)
	public void test3() {

		RequestSpecification reqSpec=RestAssured.given();

		// 3rd approach using header class
		//add header 

		Header requestHeaderObj=new Header("header1","value1" );



		reqSpec.header(requestHeaderObj);
		reqSpec.log().headers();
		//specify url
		reqSpec.baseUri("https://reqres.in/api/users");
		Response response=reqSpec.get();



	}

	@Test(enabled=false)
	public void test4() {

		RequestSpecification reqSpec=RestAssured.given();

		// 4 th approach using headers class
		//add header 

		Header requestHeaderObj1=new Header("header1","value1" );
		Header requestHeaderObj2=new Header("header2","value2" );
		Header requestHeaderObj3=new Header("header3","value3" );

		
		List<Header> headerList=new ArrayList<Header>();
		
		headerList.add(requestHeaderObj1);
		headerList.add(requestHeaderObj2);
		headerList.add(requestHeaderObj3);

		Headers headersObj=new Headers(headerList);
		
		reqSpec.headers(headersObj);
		reqSpec.log().headers();
		//specify url
		reqSpec.baseUri("https://reqres.in/api/users");
		Response response=reqSpec.get();



	}

	@Test(enabled=true)
	public void usingBDDApproach() {
		Header requestHeaderObj1=new Header("header1","value1" );
		Header requestHeaderObj2=new Header("header2","value2" );
		Header requestHeaderObj3=new Header("header3","value3" );

		
		List<Header> headerList=new ArrayList<Header>();
		
		headerList.add(requestHeaderObj1);
		headerList.add(requestHeaderObj2);
		headerList.add(requestHeaderObj3);

		Headers headersObj=new Headers(headerList);
		
		RestAssured
		.given()
			.headers(headersObj)
			.log().headers()
		.when()
			.get("https://reqres.in/api/users?page=1")
		.then()
			.statusCode(200)
			.log().body();
	}

	
	
}
