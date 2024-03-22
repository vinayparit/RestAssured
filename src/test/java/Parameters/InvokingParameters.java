package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class InvokingParameters {

	@Test
	void pathParameter() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().pathParam("pId", "TY_PROJ_016").when().get("/projects/{pId}").then().assertThat().statusCode(200).log()
				.all();
	}

	@Test
	void queryParameter() {
		baseURI = "http://reqres.in";

		given().queryParam("page", 2).when().get("/api/users").then().assertThat().statusCode(200).log().all();
	}

	@Test
	void formParameter() {
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().formParam("createdBy", "RCB").formParam("projectName", "ESCN").formParam("status", "Pakka")
				.formParam("teamSize", 25).when().post("/addProject").then().assertThat().statusCode(201).log().all();
	}
}
