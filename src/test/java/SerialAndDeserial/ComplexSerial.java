package SerialAndDeserial;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoArray;


public class ComplexSerial {

	@Test
	void serialArray() throws JsonGenerationException, JsonMappingException, IOException
	{
		long[] empPhone= {7204469689l,9448876171l};
		
		File file = new File("./employeeArray.json");
		PojoArray pe=new PojoArray("Vinay","Belagavi",empPhone);
		
		ObjectMapper oMap = new ObjectMapper();
		oMap.writeValue(file, pe);
	}
	@Test
	void deserailArray() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper oMap = new ObjectMapper();
		PojoArray e=oMap.readValue(new File("./employeeArray.json"), PojoArray.class);
		
		System.out.println(e.getEmpName());
		System.out.println(e.getEmpLocation());
		System.out.println(e.getEmPhone()[0]);
		System.out.println(e.getEmPhone()[1]);
	}
}
