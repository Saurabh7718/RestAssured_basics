package Z_17_lecture_Jackson_API;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.testng.annotations.Test;
import java.util.*;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class X_01_creation_of_json_object_using_jackson_api {
	@Test
	public void creationOfJsonObject() {

		// https://reqres.in/api/users

		// create objectmapper class instance
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode userDetails = objectMapper.createObjectNode();

		userDetails.put("firstName", "Prerna");
		userDetails.put("lastName", "gupta");
		userDetails.put("age", 28);
		userDetails.put("salary", 10000);
		userDetails.put("IsMarried", false);
		userDetails.set("Hobbies", objectMapper.convertValue(Arrays.asList("music","cricket"), JsonNode.class));
		
		
		
		ObjectNode techSkills = objectMapper.createObjectNode();

		techSkills.put("programming language", "java");
		techSkills.put("web automation", "selenium");
		techSkills.put("backend automation", "rest assured");

		userDetails.set("techSkills", techSkills);

		// print user details JSON object

		try {
			String userDetailsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);

			System.out.println("created JSON node:" + userDetailsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// retrive field value
		String firstName = userDetails.get("firstName").asText();
		System.out.println("value of firstname field is: " + firstName);

		Boolean isMarried = userDetails.get("IsMarried").asBoolean();
		System.out.println("value of IsMarried is: " + isMarried);

		String webAutomation = userDetails.get("techSkills").get("web automation").asText();
		System.out.println("value of web automation is: " + webAutomation);

		System.out.println("-----------------------------print all field names----------------------------------");
		// print all field names
		java.util.Iterator<String> itr = userDetails.fieldNames();
		while (itr.hasNext()) {
			System.out.println(itr.next());

		}

		System.out.println("-----------------------------print all field values----------------------------------");
		java.util.Iterator<JsonNode> fieldValuesIterator = userDetails.elements();

		while (fieldValuesIterator.hasNext()) {
			System.out.println(fieldValuesIterator.next());
		}

		System.out
				.println("-----------------------------print all field names values----------------------------------");
		java.util.Iterator<Entry<String, JsonNode>> KeyvalueEnteries = userDetails.fields();

		while (KeyvalueEnteries.hasNext()) {
			Entry<String, JsonNode> node = KeyvalueEnteries.next();
			String key = node.getKey();

			Object value = node.getValue();

			System.out.println("key: " + key + " value :" + value);
		}

		// Remove json object or objectNode
		System.out.println("----------------------------remove values from objectNode----------------------------------");

		// Replace the following line
		// String removeValue = userDetails.remove(firstName).asText();

		// With this line
		JsonNode removedNode = userDetails.remove("firstName");

		// Print the removed value if needed
		System.out.println("Removed value: " + removedNode.asText());

		System.out.println(
		        "-----------------------------print all field names values after removing firstName----------------------------------");

		try {
		    String userDetailsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
		    System.out.println("created JSON node:" + userDetailsString);
		} catch (JsonProcessingException e) {
		    e.printStackTrace();
		}
		
		
		//update json object or object node
		
		userDetails.put("lastName", "kohli");
		
		System.out.println(
		        "-----------------------------print all field names values after updating lastName----------------------------------");

		try {
		    String userDetailsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
		    System.out.println("created JSON node:" + userDetailsString);
		} catch (JsonProcessingException e) {
		    e.printStackTrace();
		}
	
		//update
		techSkills.put("programming language", "C#");
		
		userDetails.set("TechSkill",techSkills );
		System.out.println(
		        "-----------------------------print all field names values after updating lastName----------------------------------");
 
	try {
	    String userDetailsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
	    System.out.println("created JSON node:" + userDetailsString);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}
		
	
	
	Response response=RestAssured
	.given()
	.contentType(ContentType.JSON)
	.baseUri("https://reqres.in/api/users")
	.body(userDetails)
	.post();
	
	
	System.out.println(response.asPrettyString());
	}
	
	
	

}
