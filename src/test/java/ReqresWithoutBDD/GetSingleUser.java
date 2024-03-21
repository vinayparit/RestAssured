package ReqresWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUser {

	@Test
	void signleUser()
	{
		RestAssured rs=new RestAssured();
		
		Response response = rs.get("https://reqres.in/api/users/2");
		
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.prettyPeek());
		
	}
}
