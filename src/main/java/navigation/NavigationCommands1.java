package navigation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands1 {
	
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
	public void NavigationMethods()
	{
		driver.navigate().to("https://www.google.com/");
		System.out.println("1:"+driver.getTitle());
		driver.manage().window().maximize();
		elementLocator = driver.findElement(By.linkText("About"));
		elementLocator.click();
		System.out.println("2:"+driver.getTitle());
		driver.navigate().back();
		System.out.println("3:"+driver.getTitle());
		driver.navigate().refresh();
		driver.navigate().forward();
		System.out.println("4:"+driver.getTitle());
	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();
		
	}

}
