package SerialAndDeserial;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoEmployee;

public class SerialAndDeserialization {

	@Test
	void serialization() throws JsonGenerationException, JsonMappingException, IOException
	{
		File file = new File("./employee.json");
		PojoEmployee pe=new PojoEmployee("Vinay","Belagavi",7204469689l);
		
		ObjectMapper oMap = new ObjectMapper();
		oMap.writeValue(file, pe);
	}
	
	@Test
	void deserialization() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper oMap = new ObjectMapper();
		PojoEmployee e=oMap.readValue(new File("./employee.json"), PojoEmployee.class);
		System.out.println(e.getEmpName());
		System.out.println(e.getEmpLocation());
		System.out.println(e.getEmpPhone());
	}
}
