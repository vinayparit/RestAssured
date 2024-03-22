package Pojo;

public class PojoEmployee {

	String empName;
	String empLocation;
	long empPhone;
	
	public PojoEmployee(String empName, String empLocation,long empPhone )
	{
		this.empName=empName;
		this.empLocation=empLocation;
		this.empPhone=empPhone;
	}
	
//	Empty Constructor for De-Serialization
	public PojoEmployee()
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

	public long getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(long empPhone) {
		this.empPhone = empPhone;
	}
	
}

