package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithJsonFile {

	@Test
	void createProject() {
		File file = new File("./data.json");

		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().body(file).contentType(ContentType.JSON)

				.when().post("/addProject").then().assertThat().statusCode(201).contentType(ContentType.JSON).log()
				.all();

	}
}
