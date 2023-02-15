package js_executor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteScriptAPI {
	WebDriver driver1=null;
	JavascriptExecutor js =null;
	

	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver1 = new ChromeDriver();
		driver1.manage().deleteAllCookies();
		driver1.manage().window().maximize();
		js = (JavascriptExecutor)driver1;
	}
	
	@Test
	public void learnAPI1()
	{
		
		driver1.get("https://www.google.com/");
		Object response= js.executeScript("console.log('Hello there.');");
		System.out.println("Completed:"+ response);
	}
	
	@Test
	public void learnAPI2()
	{
		
		Object b = js.executeScript("return(1==2);");
		System.out.println("Completed:"+b);

	}
	
	@Test
	public void learnAPI3()
	{
		Object c= js.executeScript("console.log('Hello '+arguments[0]+'.Welcome to '+arguments[1]+'.');","RASHMI","MAKESELENIUMEASY");
		System.out.println("Completed:"+c);

	}
	
	@After
	public void closeSession()
	{
		driver1.close();
		driver1.quit();	
	}
}
