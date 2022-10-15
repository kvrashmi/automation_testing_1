package webbased_alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;

public class PromptAlerts {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		
		/*
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		   driver.manage().window().maximize();
		  // This step will result in an alert on screen
		   WebElement element = driver.findElement(By.id("promtButton"));
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		   Alert promptAlert  = driver.switchTo().alert();
		   String alertText = promptAlert.getText();
		   System.out.println("Alert text is: " + alertText);
		  //Send some text to the alert
		   promptAlert.sendKeys("Rashmi Kanuppa");
		   promptAlert.accept();
		   */
		
		Assert.assertEquals("abc", "abc");
		 Result result = JUnitCore.runClasses(PromptAlerts.class);					
		for (Failure failure : result.getFailures()) 
		{							
			System.out.println(failure.toString());					
		}		
		System.out.println("Result=="+result.wasSuccessful());	
	}

}
