package wait;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitFluentWait {
	
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
		FluentWait wait = new FluentWait(driver1);
		//Specify the timout of the wait
		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
		//Sepcify polling time
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		//Specify what exceptions to ignore
		wait.ignoring(NoSuchElementException.class);
		
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver arg0) {
				System.out.println("Checking for the element!!");
				WebElement element = arg0.findElement(By.id("selenium_commands"));
				if(element != null)
				{
					System.out.println("Target element found");
				}
				return element;
			}
		};

		wait.until(function);

		//WebDriverWait wait = new WebDriverWait(driver1,30);
		//wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("selenium_commands"),By.tagName("option")));
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
