package crm_concepts;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
	
	public static WebDriver driver;
	static String URL = "https://objectspy.space/";

	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		//ImplicitWait
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void launchWebPage()
	{
		System.out.println("Launching page...");
		driver.get(WebDriverMethods.URL);
		System.out.println("Page launched successfully...");
	}
	
	@Test
	public void getTitle()
	{
		String title=driver.getTitle();
		System.out.println("Page Title:"+title);
	}
	
	@Test
	public void getCurrentUrl()
	{
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL:"+currentUrl);
		if (currentUrl.equals(WebDriverMethods.URL)){ 
			System.out.println("Verification Successful - The correct Url is opened.");
		}
		else {
			System.out.println("Verification Failed - An incorrect Url is opened."); 
			//In case of Fail, you like to print the actual and expected URL for the record purpose 
			System.out.println("Actual URL is : " + currentUrl); 
			System.out.println("Expected URL is : " +WebDriverMethods.URL );
		}
	}

	@Test
	public void getPageSource()
	{
		String pageSource = driver.getPageSource();
		System.out.println("PageSource Length:"+pageSource.length());
	}
	
	@Test
	public void getElementById() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='openwindow']")).click();
		System.out.println("MessageWindowButton Clicked...");
	}
	
	@Test
	public void navigateToAnotherPage() throws InterruptedException
	{
		driver.navigate().to("https://objectspy.space/SQL.html");
		System.out.println("Opened ObjectSpy Space SQL...");
		driver.navigate().back();
		System.out.println("Navigated Back...");
		driver.navigate().refresh();
		System.out.println("Page Refreshed...");
		driver.navigate().forward();
		System.out.println("Navigated Forwarded...");


	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.quit();
	}
	
	
}
