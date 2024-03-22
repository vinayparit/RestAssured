package Pojo;

public class PojoArray {

	String empName;
	String empLocation;
	long[] emPhone;
	
	public PojoArray(String empName,String empLocation,long[] empPhone)
	{
		this.empName=empName;
		this.empLocation=empLocation;
		this.emPhone=empPhone;
	}
	
	public PojoArray()
	{
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public long[] getEmPhone() {
		return emPhone;
	}

	public void setEmPhone(long[] emPhone) {
		this.emPhone = emPhone;
	}
	
}
