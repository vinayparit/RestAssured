package ReqresWithoutBDD;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllUsers {

	@Test
	void allUsers()
	{
		RestAssured rs=new RestAssured();
		 Response resp = rs.get("https://reqres.in/api/users");
		 
		 System.out.println(resp.statusCode());
		 System.out.println(resp.then().log().all());
	}
}
