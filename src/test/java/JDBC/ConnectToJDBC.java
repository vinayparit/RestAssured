package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ConnectToJDBC {

	@Test
	public void connectToDataBaseEmp() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("select * from employee;");
		int i = 1;
		while (result.next()) {
			System.out.println(result.getString(i));
			i++;
		}
	}

	@Test
	public void connectToDataBaseProject() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("select * from project;");
		int i = 1;
		while (result.next()) {
			System.out.println(result.getString(i));
			i++;
		}

	}
	@Test
	public void createProject() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
