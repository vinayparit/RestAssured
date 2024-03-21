package CRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProject {

	@Test
	void getSingleProject() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		when().get("/projects/TY_PROJ_151")

				.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();

	}
}
