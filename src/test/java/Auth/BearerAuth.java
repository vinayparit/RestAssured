package Auth;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerAuth {

	@Test
	void bearerAuth()
	{
		baseURI="https://api.github.com";
		JSONObject js = new JSONObject();
		js.put("name", "RestAssuredTest");
		
		
		given().auth().oauth2("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").body(js).contentType(ContentType.JSON)
		
		.when().post("/user/repos")
		.then().assertThat().statusCode(201).log().all();
		
	}
}
