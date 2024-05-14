package Z_18_lecture_upload_file;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_upload_file {
	//https://httpbin.org/post
	@Test(enabled=false)
	public void upload_file_single_file() {
		//cerate file object
		
		File testFileUpload=new File("C:\\Users\\Lenovo\\Downloads\\test.txt");
		
		RequestSpecification requestSpec=RestAssured.given();
		
		requestSpec.baseUri("https://httpbin.org/post");
		requestSpec.multiPart("file",testFileUpload);
		requestSpec.contentType("multipart/form-data");//imp interview question
		
		Response response=requestSpec.post();
		
		response.prettyPrint();
		
		
		Assert.assertEquals(response.statusCode(), 200,"check request type");
	}
	@Test
	public void upload_file_multiple_file() {
		//cerate file object
		
		File testFileUpload=new File("C:\\Users\\Lenovo\\Downloads\\test.txt");
		File testFileUpload1=new File("C:\\Users\\Lenovo\\Downloads\\test1.txt");
		
		RequestSpecification requestSpec=RestAssured.given();
		
		requestSpec.baseUri("https://httpbin.org/post");
		requestSpec.multiPart("file",testFileUpload);
		requestSpec.multiPart("file",testFileUpload1);
		requestSpec.contentType("multipart/form-data");//imp interview question
		
		Response response=requestSpec.post();
		
		response.prettyPrint();
		
		
		Assert.assertEquals(response.statusCode(), 200,"check request type");
	}

}
