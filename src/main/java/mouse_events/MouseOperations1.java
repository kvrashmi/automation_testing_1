package mouse_events;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MouseOperations1 {
	
	public static WebDriver driver1;
	static String URL1 = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
	
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
	public void performRightClick()
	{
		driver1.get(URL1);
		WebDriverWait wait = new WebDriverWait(driver1,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='right click me']")));
		//Actions class is required for mouse events
		Actions actions = new Actions(driver1);
		actions.contextClick(driver1.findElement(By.xpath("//span[text()='right click me']"))).perform();	
	}
	
	@Test
	public void performDoubleClick()
	{
		
	}
	
	@After
	public void closeSession()
	{
		//driver1.close();
	}
	
	@AfterClass
	public static void tearDown()
	{
		//driver1.quit();
	}

	

}
