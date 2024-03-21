package CRUDwithoutBDD;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	void deleteProject() {
		
		RestAssured rs=new RestAssured();
		Response response = rs.delete("http://rmgtestingserver:8084/projects/TY_PROJ_009");
		
		int actStatus=response.getStatusCode();
		System.out.println(actStatus);
		assertEquals(actStatus, 204);
				
		
	}
}
