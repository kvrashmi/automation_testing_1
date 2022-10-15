package crm_concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	static WebDriver driver;
	
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	}
	
	public static void launchBrowser()
	{
		driver = new ChromeDriver();
		
		//clear cookies
		driver.manage().deleteAllCookies();
		
		//go to url
		driver.get("https://techfios.com/billing/?ng=admin/");
		
		//maximize window
		driver.manage().window().maximize();
				
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public static void loginTest()
	{
		//Enter Username -
		//How to identify - inspect the web page
		//id => username
		WebElement username = driver.findElement(By.id("username"));
		
		//Input Username
		username.sendKeys("demo@techfios.com");
		
		//Enter Password
		//id=> password
		WebElement password = driver.findElement(By.id("password"));
		
		//Input password
		password.sendKeys("abc123");
		
		//sign-in
		//name=> "login"
		WebElement login = driver.findElement(By.name("login"));
		
		//Click Login
		login.click();
				
	}
	
	public void negLoginTest()
	{
		//Enter Username -
		//How to identify - inspect the web page
		//id => username
		WebElement username = driver.findElement(By.id("username"));
		
		//Input Username
		username.sendKeys("demo@techfios.com");
		
		//Enter Password
		//id=> password
		WebElement password = driver.findElement(By.id("password"));
		
		//Input password
		password.sendKeys("abc12");
		
		//sign-in
		//name=> "login"
		WebElement login = driver.findElement(By.name("login"));
		
		//Click Login
		login.click();
						
	}
	
	public static void tearDown()
	{
		//close browser
		driver.close();
	}
	
	public static void main(String[] args) {

		
	}
	
}
