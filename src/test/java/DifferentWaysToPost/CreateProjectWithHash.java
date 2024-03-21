package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Generic.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectWithHash {

	@Test
void createProject() {
		
		JavaUtility jLib = new JavaUtility();


		// Request Body
		HashMap hashMap = new HashMap();
		hashMap.put("createdBy", "Vinay");
		hashMap.put("projectName", "OSA RestAssured with HashMap Data " + jLib.getRandomNum(500));
		hashMap.put("status", "Completed");
		hashMap.put("teamSize", 20);
		
		baseURI="http://rmgtestingserver:";
		port=8084;
		
		given().body(hashMap).contentType(ContentType.JSON)
		
		.when().post(baseURI+port+"/addProject")
		
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
		

		
	}
}
