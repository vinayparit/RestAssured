package CRUDwithoutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetProject {

	@Test
	void getProject() {
		
		RestAssured rs=new RestAssured();
		Response get = rs.get("http://rmgtestingserver:8084/projects/TY_PROJ_009");
		get.then().log().all();
		
		//validation
		int actStatusCode=get.getStatusCode();
		System.out.println(actStatusCode);
		assertEquals(actStatusCode, 200);
	}
}
