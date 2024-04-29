package Auth;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2 {

	@Test
	void oAuth2() {
		Response res = given().formParam("client_id", "IPL")
				.formParam("client_secret", "e9993472824c5aee56df0f7357f622e5")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://iplrcb.com")
				.formParam("code", "authorization_code")
				.when().post("http://coop.apps.symfonycasts.com/token");
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		
		given().auth().oauth2(token).pathParam("USER_ID",4872)
		
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then().log().all();

	}
}
