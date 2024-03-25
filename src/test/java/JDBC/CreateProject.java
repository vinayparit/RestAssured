package JDBC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateProject {

	
	@Test
	public void createProject() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("OSA Trail001");
		driver.findElement(By.name("createdBy")).sendKeys("vin");
		WebElement status = driver.findElement(By.name("status"));
		
		Select sel=new Select(status);
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@class=\"btn btn-success\"]")).click();
	}
}
