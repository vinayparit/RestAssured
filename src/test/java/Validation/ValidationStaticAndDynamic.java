package Validation;

import static org.testng.Assert.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidationStaticAndDynamic {

	@Test
	void staticValidation() 
	{
		String expData = "TY_PROJ_016";
		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = when().get("/projects");

		String pId = resp.jsonPath().get("[0].projectId");

		assertEquals(expData, pId);
		
		System.out.println("Data is Present");
	}
	 @Test
	void dynamicValidation()
	{
		String expData = "TY_PROJ_016";
		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = when().get("/projects");

		boolean flag=false;
		List<String> pId = resp.jsonPath().get("projectId");
		
		for(String projectId: pId)
		{
			flag=true;
		}
		assertTrue(flag);
		System.out.println("data present");
		resp.then().log().all();
	}
}
