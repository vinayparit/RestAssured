package CRUDwithPojo;

import org.testng.annotations.Test;

import Generic.JavaUtility;
import Pojo.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithPojo {

	@Test
	void createProjectWithPojo() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaUtility jLib = new JavaUtility();

		PojoClass pj = new PojoClass("Vinayak", "IPL"+jLib.getRandomNum(500), "Started", 12);

		given().body(pj).contentType(ContentType.JSON)

				.when().post("/addProject")

				.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
}
