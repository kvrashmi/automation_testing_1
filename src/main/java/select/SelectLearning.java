package select;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectLearning {
	
	static WebDriver driver;
	static String optGroupUrl="file:///Users/rashmikanduluvavikraman/selenium-workspace/crm/src/main/java/select/sampleselect.html";
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		System.out.println("Launching page...");
		driver.get(optGroupUrl);
		System.out.println("Page launched successfully...");
	}
	
	@Test
	public void selectAValueFromOptGroup()
	{
		System.out.println("Selecting a value from optgroup...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='dino-select']")));
		sel.selectByVisibleText("Velociraptor");
		 
	}
	
	@Test
	public void getOptionsFromAOptGroup()
	{
		System.out.println("GettingOptionsFromOptGroup...");
		List<WebElement> optionsFromOptGroup = driver.findElements(By.xpath("//select[@id='dino-select']/optgroup[@label='Theropods']/option"));
		for(WebElement opt:optionsFromOptGroup)
		 {
	         String text=opt.getText();
	         System.out.println(text);
	     }
	}
	
	@Test
	public void selectDDOptionByIndex() 
	{
		System.out.println("Selecting option by index...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='dog-select']")));
		sel.selectByIndex(4);
	}
	
	@Test
	public void selectDDOptionByValue()
	{
		System.out.println("Selecting option by value...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='cat-select']")));
		sel.selectByValue("c_sf");
	}
	
	@Test
	public void selectDDOptionByVisibleText()
	{
		System.out.println("Selecting multiple options from multi-select...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='parrot-select']")));
		sel.selectByVisibleText("Parakeets");
		sel.selectByVisibleText("Cockatoos");
	}
	
	@Test
	public void getAllOptionsFromDD()
	{
		System.out.println("Getting all options...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='dino-select']")));
		List<WebElement> options1= sel.getOptions();
		int i=0;
		for(WebElement o:options1)
		{
			System.out.println(i++ + " " + o.getText());
		}
	}
	
	@Test
	public void getAllSelectedOptionsFromDD()
	{
		System.out.println("Getting all the selected options from multi-select...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='parrot-select']")));
		List<WebElement> options1= sel.getAllSelectedOptions();
		int i=0;
		for(WebElement o:options1)
		{
			System.out.println(i++ + o.getText());
		}
	}
	
	@Test
	public void getSelectedOptionFromDD()
	{
		System.out.println("Getting the selected option from single select...");
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='dog-select']")));
		WebElement options1= sel.getFirstSelectedOption();
		System.out.println(options1.getText() + " : " + options1.getAttribute("value"));
		
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.quit();
	}
	
	

}
