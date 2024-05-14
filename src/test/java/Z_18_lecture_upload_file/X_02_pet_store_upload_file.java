package Z_18_lecture_upload_file;

import java.io.File;

 import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_02_pet_store_upload_file {

	//https://petstore.swagger.io/v2/pet/123/uploadImage
	@Test
	public void upload_image() {
		
		File imageUpload=new File("C:\\Users\\Lenovo\\Downloads\\cricket1.jpg");
		
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://petstore.swagger.io/v2/pet/123/uploadImage");
		requestSpec.multiPart(imageUpload);
		Response response=requestSpec.post();
		
		response.prettyPrint();
		
		
		
		
	}
	
}
