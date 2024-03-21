package CRUDwithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  io.restassured.http.ContentType;

public class UpdateProject {

	@Test
	void updateProject() {
		// Request Body
		JSONObject js = new JSONObject();
		js.put("createdBy", "Vinay P");
		js.put("projectName", "OSA RestAssured with BDD");
		js.put("status", "Completed");
		js.put("teamSize", 25);

		baseURI = "http://rmgtestingserver:";
		port = 8084;
		
		given().body(js).contentType(ContentType.JSON)

				.when().put(baseURI + port + "/projects/TY_PROJ_151")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();

	}
}
