package Generic;


import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationBuildersBaseClass {

	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec; 
			
	@BeforeSuite
	
	public void bsConfig()
	{
		// Create an object for RequestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		//Set the base URL of the API Requests
		builder.setBaseUri("http://rmgtestingserver:8084");
		
		// Set content type for the API Call requests
		builder.setContentType(ContentType.JSON);
		
		 requestSpec = builder.build();
		
		 //This will give the specification common for all api response
		ResponseSpecBuilder  builder1=new ResponseSpecBuilder();
		
		//This is common status code for all the post request as response
		builder1.expectStatusCode(201);
		
		//This is common content type for all the post request as response
		builder1.expectContentType(ContentType.JSON);
		
		
		 
		 responseSpec = builder1.build();
	}
	
			
}
