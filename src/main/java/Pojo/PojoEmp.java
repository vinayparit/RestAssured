package Pojo;

public class PojoEmp {

	String empName;
	String empLocation;
	long[] emPhone;
	PojoSpouse Spouse;

	
	
	public PojoEmp(String empName, String empLocation, long[] emPhone, PojoSpouse spouse) {
		super();
		this.empName = empName;
		this.empLocation = empLocation;
		this.emPhone = emPhone;
		Spouse = spouse;
	}

	public PojoEmp()
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

	public PojoSpouse getSpouse() {
		return Spouse;
	}

	public void setSpouse(PojoSpouse spouse) {
		Spouse = spouse;
	}

}
