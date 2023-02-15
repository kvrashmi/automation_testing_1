package js_executor;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteAsyncScriptAPI {
	WebDriver driver1=null;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver1 = new ChromeDriver();
		driver1.manage().deleteAllCookies();
		driver1.manage().window().maximize();
	}
	
	@Test
	public void Test1()
	{
		System.out.println("Start time: " + new Date());
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1],5000);");
		System.out.println("End time: "+ new Date());
	}
	
	@After
	public void closeSession()
	{
		driver1.close();
		driver1.quit();	
	}
	
	
	
}
