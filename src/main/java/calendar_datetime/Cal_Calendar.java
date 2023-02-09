package calendar_datetime;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cal_Calendar {
	
	static WebDriver driver;
	static String optGroupUrl="http://www.techfios.com/billing/?ng=admin/";
	static String current_url="";
	static String previous_url="";
	
	public static String getCurrentUrlForHM1()
	{
		current_url=driver.getCurrentUrl();
		System.out.println("current url:"+current_url);
		return current_url;
	}
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(optGroupUrl);
	}
	
	@Test
	public void A() 
	{
		System.out.println("TC1_Login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String current_url=getCurrentUrlForHM1();
		
		//username: /html/body/div/div/div/form/div[1]/input
		WebElement username = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
		System.out.println("Identified username...");
		
		//password: //input[@id='password']
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		System.out.println("Identified password...");
		
		username.sendKeys("demo@techfios.com");
		password.sendKeys("abc123");
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		if(loginBtn.isDisplayed())
		{
			loginBtn.submit();
		}
		System.out.println("Login Button Clicked...");
	}
	
	
	@Test
	public void B()
	{
		System.out.println("TC2_Calendar_Scroll");
		current_url=getCurrentUrlForHM1();
		
		if(current_url.equals("https://techfios.com/billing/?ng=dashboard/"))
		{
			WebElement calendar = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/a/span"));
			System.out.println(calendar.getText());
			calendar.click();
			try {
				Thread.sleep(3000);	
				WebElement backtrack = driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[1]/div/button[1]/span"));
				backtrack.click();
				String monthTitle = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/h2")).getText();
				System.out.println("Back Click Month Title:"+monthTitle);
				
				WebElement today = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/button"));
				today.click();
				monthTitle = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/h2")).getText();
				System.out.println("Today Click Month Title:"+monthTitle);
				
				WebElement forwardtrack = driver.findElement(By.xpath("//*[@id='calendar']/div[1]/div[1]/div/button[2]/span"));
				forwardtrack.click();
				monthTitle = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/h2")).getText();
				System.out.println("Forward Click Month Title:"+monthTitle);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Test
	public void C()
	{
		System.out.println("TC3_Get Todays Date");
		WebElement calendar = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/a/span"));
		System.out.println(calendar.getText());
		calendar.click();
		try {
			Thread.sleep(3000);	
			
			WebElement today = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/button"));
			today.click();
			String monthTitle = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/h2")).getText();
			System.out.println("Today Click Month Title:"+monthTitle);
			
			//click on today's date
			WebElement date1=driver.findElement(By.xpath("//*[@id='calendar']/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[1]/table/tbody/tr/td[5]"));
			System.out.println("Todays date:"+date1.getAttribute("data-date"));
			
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void D()
	{
		System.out.println("TC4_Click Date_Enter Details");
		WebElement calendar = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/a/span"));
		System.out.println("Get Text:"+calendar.getText());
		calendar.click();
		try {
			Thread.sleep(3000);	
			
			WebElement today = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/button"));
			today.click();
			String monthTitle = driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/h2")).getText();
			System.out.println("Today Click Month Title:"+monthTitle);
			
			//click on today's date
			WebElement date1=driver.findElement(By.xpath("//*[@id='calendar']/div[2]/div/table/tbody/tr/td/div/div/div[1]/div[1]/table/tbody/tr/td[5]"));
			System.out.println("Todays date:"+date1.getAttribute("data-date"));
			date1.click();
			
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext())
			{
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window
			
			// Now you are in the popup window, perform necessary actions here
			//Title
			WebElement title = driver.findElement(By.id("title"));
			title.sendKeys("RKV_Event1");
			
			//Start Date
			WebElement sDate = driver.findElement(By.xpath("//*[@id=\"start\"]"));
			sDate.click();
			Thread.sleep(6000);
			
			//Select date from date picker
			WebElement sDatePicker = driver.findElement(By.xpath("//*[@id='start_table']"));
			//First let us make sure this element is available.
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(sDatePicker));
			//Select a start date:
			WebElement dateToPick1 = driver.findElement(By.xpath("//*[@id='start_table']/tbody/tr/td[1]/div"));
			System.out.println("Start Date Selected:"+dateToPick1.getAttribute("aria-label"));
			dateToPick1.click();
			
			
			//End Date
			WebElement eDate = driver.findElement(By.xpath("//*[@id=\"end\"]"));
			eDate.click();
			Thread.sleep(6000);
			WebElement eDatePicker = driver.findElement(By.xpath("//*[@id='end_table']"));
			//First let us make sure this element is available.
			WebDriverWait wait1 = new WebDriverWait(driver,120);
			wait1.until(ExpectedConditions.visibilityOf(eDatePicker));
			//Select a start date:
			WebElement dateToPick2 = driver.findElement(By.xpath("//*[@id='end_table']/tbody/tr[5]/td[3]/div"));
			System.out.println("End Date Selected:"+dateToPick2.getAttribute("aria-label"));
			dateToPick2.click();
			
			
			//Select time from time picker
			
			driver.switchTo().window(parentWindowHandler);  // switch back to parent window
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	@AfterClass
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
