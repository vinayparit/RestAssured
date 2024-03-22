package Pojo;

public class PojoSpouse {
	String spouseName;
	String spouseLocation;
	long[] spousePhone;
	
	public PojoSpouse(String spouseName,String spouseLocation,long[] spousePhone)
	{
		this.spouseName=spouseName;
		this.spouseLocation=spouseLocation;
		this.spousePhone=spousePhone;
	}
	
	public PojoSpouse()
	{
		
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseLocation() {
		return spouseLocation;
	}

	public void setSpouseLocation(String spouseLocation) {
		this.spouseLocation = spouseLocation;
	}

	public long[] getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(long[] spousePhone) {
		this.spousePhone = spousePhone;
	}
	
	
}
