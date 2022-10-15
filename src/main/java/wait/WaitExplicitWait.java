package wait;


import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExplicitWait {
	
	public static WebDriver driver1;
	static String URL1 = "https://objectspy.space/";
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
	}
	
	@Before
	public void startSession()
	{
		driver1 = new ChromeDriver();
		driver1.manage().deleteAllCookies();
		driver1.manage().window().maximize();
	}
	
	@Test
	public void learnExplicitWait()
	{
		driver1.get(URL1);
		//selenium_commands
		WebDriverWait wait = new WebDriverWait(driver1,30);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("selenium_commands"),By.tagName("option")));
		
		Select sel = new Select(driver1.findElement(By.id("selenium_commands")));
		sel.selectByIndex(1);
		System.out.println("Option Selected");
		WebElement options1= sel.getFirstSelectedOption();
		System.out.println(options1.getText() + " : " + options1.getAttribute("value"));
	}
	
	@After
	public void closeSession()
	{
		driver1.close();
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver1.quit();
	}
}
