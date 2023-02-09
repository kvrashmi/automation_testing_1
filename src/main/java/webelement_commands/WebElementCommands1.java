package webelement_commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands1 {
	public static WebDriver driver;
	WebElement elementLocator = null;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void BrowserMethods()
	{
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		elementLocator = driver.findElement(By.name("q"));
		elementLocator.sendKeys("Rashmi Vikraman");
		elementLocator.clear();
		elementLocator=driver.findElement(By.linkText("About"));
		elementLocator.click();

	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();	
	}

}
