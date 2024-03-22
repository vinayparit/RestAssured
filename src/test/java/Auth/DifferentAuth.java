package Auth;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DifferentAuth {

	@Test
	void basicAuth() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	
	@Test
	void preemptiveAuth() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
	
	@Test
	void digestAuth() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().assertThat().statusCode(202).log().all();
	}
}
