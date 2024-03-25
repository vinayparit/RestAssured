package Practice;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import Generic.JavaUtility;
import Pojo.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProjectWithCRUD {

	@Test
	public void createProject() throws SQLException {

		JavaUtility jLib = new JavaUtility();
		int i = jLib.getRandomNum(500);
		PojoClass pj = new PojoClass("Vinay", "OSA" + i, "Completed", 25);

		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = given().body(pj).contentType(ContentType.JSON)

				.when().post("/addProject");
		String pName = resp.jsonPath().get("projectName");
		resp.then().assertThat().statusCode(201).log().all();
		
		Driver sdriver = new Driver();
		DriverManager.registerDriver(sdriver);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("select project_name from project;");
		int j = 1;

		while (result.next()) {
			String actualData = result.getString(j);

			if (actualData.equalsIgnoreCase(pName)) {
				System.out.println("Data Present in DataBase");
			}
		}
	
	}
}
