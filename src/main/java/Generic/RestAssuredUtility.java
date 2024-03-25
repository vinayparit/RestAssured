package Generic;

import io.restassured.response.Response;

public class RestAssuredUtility {

	/*
	 * This method will return json data from the correspondiiing response body
	 * @author Vinay Parit
	 * @param response
	 * @param path
	 */
	
	public String getJsonData(Response response,String path)
	{
	
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
}
