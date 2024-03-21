package CRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject {

	@Test
	void deleteProject() {
		
		baseURI="http://rmgtestingserver";
		port = 8084;
		
		when().delete("/projects/TY_PROJ_151")
		
		.then().assertThat().statusCode(204).log().all();
	}
}
