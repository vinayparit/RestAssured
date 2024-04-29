package shopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RegisterShopper {

	@Test
	public void registerShopper()
	{
		baseURI="https://www.shoppersstack.com/shopping"; 
		JSONObject js=new JSONObject();
		js.put("city", "Bangalore");
		js.put("country", "India");
		js.put("email", "yaniv@gmail.com");
		js.put("firstName", "Vinay");
		js.put("gender", "Male");
		js.put("lastName", "P");
		js.put("password", "Vinay@123");
		js.put("phone", "9019960289");
		js.put("state", "Kar");
		js.put("zoneId", "ALPHA");
		
		given().body(js).contentType(ContentType.JSON)
		.when().post("/shoppers")
		.then().log().all();
		
		
	}
}
