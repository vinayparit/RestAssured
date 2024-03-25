package Generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	public void waitUntilPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		
	}
	
	public void waitUntilElementClickable(WebDriver driver, int sec, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void closeWindow(WebDriver driver)
	{
		driver.close();
	}
}
