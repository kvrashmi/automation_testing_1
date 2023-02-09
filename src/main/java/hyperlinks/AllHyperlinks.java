package hyperlinks;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllHyperlinks {
	
	public static WebDriver driver;
	List<WebElement> elementLocator = null;
	List<String> originalList=null;
	
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
		elementLocator = driver.findElements(By.tagName("a"));
		originalList=elementLocator.stream().map(s->s.getAttribute("href")).collect(Collectors.toList());
		System.out.println(originalList);
		
	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();	
	}


}
