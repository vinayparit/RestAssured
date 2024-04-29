package Practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic.EndPoints;
import Generic.JavaUtility;
import Generic.SpecificationBuildersBaseClass;
import Pojo.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyInUI extends SpecificationBuildersBaseClass {

	@Test
	public void createProject() {
		JavaUtility jLib = new JavaUtility();
		int i = jLib.getRandomNum(500);
		PojoClass pj = new PojoClass("Vinay", "OSA" + i, "Completed", 25);

//		baseURI = "http://rmgtestingserver";
//		port = 8084;

		Response resp = given().spec(requestSpec).body(pj)

				.when().post(EndPoints.project_addProject);
		String pName = resp.jsonPath().get("projectName");
		resp.then().spec(responseSpec).assertThat().log().all();

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
				 System.out.println("Project is created :"+projectNam);
				 break;
			 }
			 
			 
		 }
		
	}
}
