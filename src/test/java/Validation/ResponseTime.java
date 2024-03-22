package Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ResponseTime {

	@Test
	void responseTime() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		File file = new File("./data.json");
		given().body(file).contentType(ContentType.JSON)

				.when().post("/addProject")

				.then().assertThat().time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS)
				.log().all();

	}
}
