package ReqresWithBDD;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUser {

	@Test
	void createUser()
	{
		HashMap hMap=new HashMap();
		hMap.put("name", "Nick");
		hMap.put("job", "Plumber");
		
		baseURI="https://reqres.in";
		
		given().body(hMap).contentType(ContentType.JSON)
		
		.when().post("/api/users")
		
		.then().statusCode(201).contentType(ContentType.JSON).log().all();
		
	}
}
