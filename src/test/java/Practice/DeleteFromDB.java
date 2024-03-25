package Practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

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

import com.mysql.cj.jdbc.Driver;

import Generic.JavaUtility;
import Pojo.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteFromDB {

	public void createProject() throws SQLException {
		JavaUtility jLib = new JavaUtility();
		int i = jLib.getRandomNum(500);
		PojoClass pj = new PojoClass("Vinay", "OSA" + i, "Completed", 25);

		baseURI = "http://rmgtestingserver";
		port = 8084;

		Response resp = given().body(pj).contentType(ContentType.JSON)

				.when().post("/addProject");
		String pName = resp.jsonPath().get("projectName");
		resp.then().assertThat().statusCode(201).log().all();
		
		Driver sdriver = new Driver();
		DriverManager.registerDriver(sdriver);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		int result = state.executeUpdate("delete from project where project_name is +pName+;");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		 List<WebElement> proName = driver.findElements(By.xpath("//table[@class=\"table table-striped table-hover\"]/tbody/tr/td[2]"));
		 for(WebElement e:proName)
		 {
			 String projectNam = e.getText();
			 if(projectNam.equalsIgnoreCase(pName))
			 {
				 System.out.println("Project is avaliable in database :"+projectNam);
				 break;
			 }
			 else
			 {
				 System.out.println("Project is deleted");
			 }
			 
		 }
		
	}
}
