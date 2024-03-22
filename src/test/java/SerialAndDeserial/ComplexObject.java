package SerialAndDeserial;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.PojoEmp;
import Pojo.PojoSpouse;

public class ComplexObject {

	@Test
	void complexSerial() throws JsonGenerationException, JsonMappingException, IOException {
		long[] empPhone = { 7204469689l, 9019960289l };
		long[] spousePhone = { 1234567891l, 2456321456l };
		PojoSpouse spouse = new PojoSpouse("abc", "bca", spousePhone);
		PojoEmp pe = new PojoEmp("Vinay", "Belgaum", empPhone, spouse);

		File file = new File("./ComplexemployeeArray.json");

		ObjectMapper oMap = new ObjectMapper();
		oMap.writeValue(file, pe);
	}
	
	@Test
	void complexDeserial() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper oMap = new ObjectMapper();
		
		PojoEmp emp=oMap.readValue(new File("./ComplexemployeeArray.json"), PojoEmp.class);
		
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpLocation());
		System.out.println(emp.getEmPhone()[0]);
		System.out.println(emp.getEmPhone()[1]);
		System.out.println(emp.getSpouse().getSpouseName());
		System.out.println(emp.getSpouse().getSpouseLocation());
		System.out.println(emp.getSpouse().getSpousePhone()[0]);
		System.out.println(emp.getSpouse().getSpousePhone()[1]);
	}
}
