package Generic;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	
	@BeforeSuite
	public void connectToDataBase() throws SQLException
	{
		DataBaseUtility db=new DataBaseUtility();
		db.connectToDataBase();
	}
	
	@AfterSuite
	public void dissconnectFromDataBase() throws SQLException
	{
		DataBaseUtility db=new DataBaseUtility();
		db.disconnectDataBase();
	}
}
