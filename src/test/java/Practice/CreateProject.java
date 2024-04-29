package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import Generic.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.testng.Assert.assertTrue;

public class CreateProject {

	@Test
	public void createProject() throws InterruptedException, SQLException {
		JavaUtility jLib = new JavaUtility();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);

		String ProjectName = "OSA Trail" + jLib.getRandomNum(500);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(ProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("vin");
		WebElement status = driver.findElement(By.name("status"));

		Select sel = new Select(status);
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@class=\"btn btn-success\"]")).click();

		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response response = when().get("/projects");
		List<String> proName = response.jsonPath().get("projectName");
		boolean flag = false;
		for (String pName : proName) {
			if (ProjectName.equalsIgnoreCase(pName)) {
				flag = true;
				System.out.println(pName);
			}
		}
		assertTrue(flag, ProjectName);
		System.out.println("Project is Present");

		Driver sdriver = new Driver();
		DriverManager.registerDriver(sdriver);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("select project_name from project;");
		int i = 1;

		while (result.next()) {
			String actualData = result.getString(i);

			if (actualData.equalsIgnoreCase(ProjectName)) {
				System.out.println("Data Present in DataBase");
			}
		}
		baseURI="http://rmgtestingserver";
		port=8084;
		when().get("/projects/");
		con.close();
	}

}
