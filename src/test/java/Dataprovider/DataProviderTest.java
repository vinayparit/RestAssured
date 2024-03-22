package Dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.JavaUtility;
import Pojo.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderTest {

	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[4][4];

		obj[0][0] = "Virat";
		obj[0][1] = "RCB";
		obj[0][2] = "Cricket";
		obj[0][3] = 57;
	
		obj[1][0] = "Pankaj Advani";
		obj[1][1] = "IND";
		obj[1][2] = "Snooker";
		obj[1][3] = 20;

		obj[2][0] = "Alon";
		obj[2][1] = "Tesla";
		obj[2][2] = "Owner";
		obj[2][3] = 99;

		obj[3][0] = "Virat";
		obj[3][1] = "RCB";
		obj[3][2] = "Cricket";
		obj[3][3] = 57;
		return obj;
	}

	@Test(dataProvider = "data")
	void createProject(String createdBy, String projectName, String status, int teamSize) {
		JavaUtility jLib = new JavaUtility();
		PojoClass pj = new PojoClass(createdBy, projectName + jLib.getRandomNum(500), status, teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;

		given().body(pj).contentType(ContentType.JSON).when().post("/addProject").then().assertThat().statusCode(201)
				.log().all();
	}
}
