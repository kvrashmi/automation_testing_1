package wait;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class WaitImplicitWait {

	public static WebDriver driver1;
	static String URL1 = "https://objectspy.space/";
	//static String URL2 = "http://techfios.com/test/billing/?ng=admin/";
	
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
		driver1.get("chrome://settings/clearBrowserData");
	    driver1.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver1.manage().window().maximize();
	}

	@Test
	public void getPageWithImplicitWait1()
	{
		System.out.println("From ImplicitWait1:");
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver1.get(URL1);
		
		//Get the time before looking up for the element
		Instant start1 = Instant.now();
		//Look up the element
		WebElement webElement1 = driver1.findElement(By.id("continents"));
		//Get the time after the element is found.
		Instant end1 = Instant.now();
		//Find the  difference between them 
		Duration timeElapsed1= Duration.between(start1, end1);
		//That is the time approximately taken to find the element.
		System.out.println("Time taken: "+ timeElapsed1.toMillis() +" milliseconds");
		
		Instant start2 = Instant.now();
		WebElement webElement2 = driver1.findElement(By.id("selenium_commands"));
		Instant end2= Instant.now();
		Duration timeElapsed2 = Duration.between(start2, end2);
		System.out.println("Time taken: "+ timeElapsed2.toMillis()+" milliseconds");	
	}
	
	
	@Test
	public void getPageWithImplicitWait2()
	{
		System.out.println("From ImplicitWait2:");
		driver1.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver1.get(URL1);
		
		Instant start1 = Instant.now();
		WebElement webElement1 = driver1.findElement(By.id("continents"));
		Instant end1 = Instant.now();
		Duration timeElapsed1= Duration.between(start1, end1);
		System.out.println("Time taken: "+ timeElapsed1.toMillis() +" seconds");
		
		Instant start2 = Instant.now();
		WebElement webElement2 = driver1.findElement(By.id("selenium_commands"));
		Instant end2= Instant.now();
		Duration timeElapsed2 = Duration.between(start2, end2);
		System.out.println("Time taken: "+ timeElapsed2.toMillis() +" seconds");
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
