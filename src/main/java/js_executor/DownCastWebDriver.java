package js_executor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DownCastWebDriver {
	WebDriver driver1=null;
	ChromeDriver driver2 = null;
	RemoteWebDriver driver3 = null;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver1 = new ChromeDriver();
		driver2 = new ChromeDriver();
		driver3=new ChromeDriver();
		driver1.manage().deleteAllCookies();
		driver1.manage().window().maximize();
	}
	
	@Test
	public void case1()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("console.log('Hello.');");
		driver1.get("http://www.google.com/");
	}
	
	@Test
	public void case2()
	{
		driver2.executeScript("console.log('Hi.');");
		driver2.get("http://www.yahoo.com/");
	}
	
	@Test
	public void case3()
	{
		driver3.executeScript("console.log('How are you?');");
		driver3.get("http://www.hotmail.com/");
	}
	
	
	@After
	public void closeSession()
	{
		driver1.close();
		driver1.quit();	
		driver2.close();
		driver2.quit();	
		driver3.close();
		driver3.quit();	
	}
}
