package CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Generic.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {

	@Test
	void createProject() {
		
		JavaUtility jLib = new JavaUtility();


		// Request Body
		JSONObject js = new JSONObject();
		js.put("createdBy", "Vinay");
		js.put("projectName", "OSA RestAssured with BDD" + jLib.getRandomNum(500));
		js.put("status", "Completed");
		js.put("teamSize", 20);
		
		baseURI="http://rmgtestingserver:";
		port=8084;
		
		given().body(js).contentType(ContentType.JSON)
		
		.when().post(baseURI+port+"/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
		

		
	}
}
