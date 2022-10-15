package crm_concepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//Command+shift+o => to import all the libraries.
//Ctrl+shift+o => to import all the libraries.

public class LoginTest_Junit {
	static WebDriver driver;

	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	}
	
	@Before
	public void launchBrowser()
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
	
	@Test
	public void loginTest()
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
	
	@Test
	public void addContacts()
	{
		driver.get("https://techfios.com/billing/?ng=contacts/add");
		
	}
	
	@Test
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
		//to error => login1
		WebElement login = driver.findElement(By.name("login"));
		
		//Click Login
		login.click();
						
	}
	
	
	@After
	public void tearDown()
	{
		//close browser
		driver.close();
		driver.quit();
	}
}
