package CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Generic.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	void updateProject() {

		// Request Body
		JSONObject js = new JSONObject();
		js.put("createdBy", "Vinay P");
		js.put("projectName", "OSA RestAssured");
		js.put("status", "Completed");
		js.put("teamSize", 20);

		// Given Method
		RequestSpecification given = RestAssured.given();
		given.body(js);
		// Content Type
		given.contentType(ContentType.JSON);

		// Performing action
		Response responsebody = given.put("http://rmgtestingserver:8084/projects/TY_PROJ_009");

		// Validation of response
		System.out.println(responsebody.statusCode());
//		System.out.println(responsebody.asString());
//		System.out.println(responsebody.print());
		System.out.println(responsebody.prettyPrint());
	}
}
