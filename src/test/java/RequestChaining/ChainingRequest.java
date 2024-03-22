package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Generic.JavaUtility;
import Pojo.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChainingRequest {

	@Test
	void createProject()
	{
		JavaUtility jLib=new JavaUtility();
		PojoClass pj=new PojoClass("RCB", "ESCN"+jLib.getRandomNum(500),"Pakka" , 25);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		Response resp = given().body(pj).contentType(ContentType.JSON)
		
		.when().post("/addProject");
		
		String proId = resp.jsonPath().get("projectId");
		
		System.out.println(proId);
		resp.then().log().all();
		
		//Request Chaining using data from creating project
		given().pathParam("pId", proId)
		.when().get("/projects/{pId}")
		.then().statusCode(200).log().all();
	}
}
