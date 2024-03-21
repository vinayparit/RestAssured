package CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Generic.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	void createProject() {
		JavaUtility jLib = new JavaUtility();
//		RestAssured rest=new RestAssured();

		// Request Body
		JSONObject js = new JSONObject();
		js.put("createdBy", "Vinay");
		js.put("projectName", "OSA RestAssured" + jLib.getRandomNum(500));
		js.put("status", "Completed");
		js.put("teamSize", 20);

		// Given Method
		RequestSpecification given = RestAssured.given();
		given.body(js);

		// Content Type
		given.contentType(ContentType.JSON);

		// Perform Action Post Method
		Response responsebody = given.post("http://rmgtestingserver:8084/addProject");

		// Validation Part
		System.out.println(responsebody.getBody());
		System.out.println(responsebody.asString());
		System.out.println(responsebody.prettyPrint());
//		System.out.println(responsebody.prettyPeek());
		System.out.println(responsebody.statusCode());

	}
}
