package browser_commands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands1 {
	
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
		System.out.println("1:"+driver.getTitle());
		System.out.println("2:"+driver.getCurrentUrl());
		System.out.println("2:"+driver.getPageSource());

	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();	
	}

}
