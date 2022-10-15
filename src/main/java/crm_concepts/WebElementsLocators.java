package crm_concepts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * Selenium Locators:
 * Identifier
 * Class
 * Tag
 * Name
 * xPath
 * Link
 * Partial Link Text
 * css
 */
public class WebElementsLocators {
	
	public static WebDriver driver1;
	static String URL1 = "https://objectspy.space/";
	static String URL2="";
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver1 = new ChromeDriver();
		driver1.manage().deleteAllCookies();
		driver1.manage().window().maximize();
	}
	
	@Test
	public void getElements() throws InterruptedException
	{
		//By class - helps in locating elements within the DOM.
		//Methods: className,name,cssSelector,id,linkText,partialLinkText,tagName,xPath,cssSelector
		driver1.get(WebElementsLocators.URL1);
		
		//id
		WebElement dateElement = driver1.findElement(By.id("datepicker"));
		dateElement.sendKeys("09292022");
		
		//name
		WebElement firstNameTxt = driver1.findElement(By.name("firstname"));
		firstNameTxt.sendKeys("Rashmi");
		System.out.println(firstNameTxt.getAttribute("value"));
		System.out.println(firstNameTxt.getText());
		System.out.println(firstNameTxt.getCssValue("border"));

		//classname
		WebElement photoFileInput = driver1.findElement(By.className("input-file"));
		photoFileInput.sendKeys("/Users/rashmikanduluvavikraman/Desktop/KenishaKanuppa/Jisha.png");
		System.out.println(photoFileInput.getTagName());
		
		//tagname
		List <WebElement> anchorElements = (List<WebElement>) driver1.findElements(By.tagName("a"));
		/*
		for(WebElement a: anchorElements)
		{
			System.out.println(a.getAttribute("href"));
		}
		*/
		
		//LinkText and partial link text
		//linkText
		 WebElement linkText=driver1.findElement(By.linkText("Link Test : New Page"));
		 System.out.println(linkText.getAttribute("href"));
		 //partialLinkText
		 WebElement partialLinkText=driver1.findElement(By.partialLinkText("Link"));
		 System.out.println(partialLinkText.getAttribute("href"));
	
		 //CSS Selectors
		 
		 
		 //xPath 
		 
		 
		 //Saving elements using By class
		 By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
		 By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		 By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		 By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		 
	
	
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		driver1.close();
		driver1.quit();
	}
	

}
