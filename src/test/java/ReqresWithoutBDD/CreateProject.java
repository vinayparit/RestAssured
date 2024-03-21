package ReqresWithoutBDD;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	void createProject()
	{
		JSONObject js=new JSONObject();
		js.put("name", "Jack");
		js.put("job", "Trainer");
		
		RestAssured rs=new RestAssured();
		RequestSpecification given = rs.given();
		
		given.body(js).contentType(ContentType.JSON);
		
		Response response = given.post("https://reqres.in/api/users");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		
	}
}
