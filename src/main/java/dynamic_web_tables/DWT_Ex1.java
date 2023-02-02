package dynamic_web_tables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DWT_Ex1 {
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
	
	public static int pageCount()
	{
		List<WebElement> pages =driver.findElements(By.xpath("//*[@id='page-wrapper']//child::table/tfoot/tr/td/ul/li[@class='footable-page']")); 
		System.out.println("Number of Pages:"+pages.size());
		int noOfPages=pages.size();;
		return noOfPages;
	}
	
	public static void clickOnPage(int i) throws InterruptedException
	{
		System.out.println("Clicking Page:"+i);
		// Javascript executor
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
		WebElement currentPage =driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/tfoot/tr/td/ul/li[@class='footable-page']["+i+"]")); 
		System.out.println(currentPage.getText());
	    Thread.sleep(10000);
		WebDriverWait waitLink = new WebDriverWait(driver,5000);
		waitLink.until(ExpectedConditions.visibilityOf(currentPage)); 
		waitLink.until(ExpectedConditions.elementToBeClickable(currentPage));
		 
		currentPage.click();		
		System.out.println("Clicked page is:"+i);
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
		System.out.println("TC2_ClickOnCustomers");
		current_url=getCurrentUrlForHM1();
		
		if(current_url.equals("https://techfios.com/billing/?ng=dashboard/"))
		{
			WebElement customers = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
			System.out.println(customers.getText());
			customers.click();
			try {
				Thread.sleep(3000);
				WebElement listElements = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
				System.out.println(listElements.getText());
				listElements.click();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 * @Ignore public void Step3() {
	 * 
	 * System.out.println("TC3_HandlingDynamicWebTable");
	 * current_url=getCurrentUrlForHM1();
	 * 
	 * //Scenario1: Get the total number of rows in the table List<WebElement>
	 * rowCount= driver.findElements(By.xpath(
	 * "//*[@id='page-wrapper']//child::table/tbody//tr"));
	 * System.out.println(rowCount.size()); }
	 */
	
	@Ignore
	public void Step4()
	{
		System.out.println("TC3_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		
		//Scenario2: Get the total number of columns in the table
		List<WebElement> colCount= driver.findElements(By.xpath("//*[@id='page-wrapper']//child::table/tbody/tr[1]//td"));
		System.out.println(colCount.size());

	}
	
	@Ignore
	public void Step5()
	{
		System.out.println("TC3_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		
		//Scenario3: Print all the headers in the table
		List<WebElement> headers= driver.findElements(By.xpath("//*[@id='page-wrapper']//child::table/thead/tr[1]//th"));
		try 
		{
			Thread.sleep(3000);
			for(WebElement head:headers)
			{
				System.out.println("Header:"+head.getText());
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void Step6()
	{
		System.out.println("TC3_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		
		//Scenario4: Get the id number in the first row
		WebElement id= driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/tbody/tr[1]/td[1]"));
		WebDriverWait waitId = new WebDriverWait(driver,30);
		waitId.until(ExpectedConditions.visibilityOf(id)); 
		System.out.println("Id:"+id.getText());	
	}
	
	@Ignore
	public void Step7()
	{
		System.out.println("TC3_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();

		//Scenario5: check if the corresponding company name is 'TechFios' for that id - traverse
		WebElement companyName = driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/tbody/tr/td[1]//following-sibling::td[3]"));
		WebDriverWait waitCompName = new WebDriverWait(driver,300);
		waitCompName.until(ExpectedConditions.visibilityOf(companyName)); 
		System.out.println("CompanyName:"+companyName.getText());
		Assert.assertEquals("Mismatch in company name...","Techfios", companyName);	
	}
	
	@Ignore
	public void Step8()
	{
		System.out.println("TC8_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		
		//Scenario6: Check if this name exists anywhere in the table and if so, get the corresponding company
		WebElement companyOfEmployee=driver.findElement(By.xpath("(//*[@id='page-wrapper']//child::table/tbody/tr/td/a[contains(text(),'Jeo Jeo569')])[1]//parent::td//following-sibling::td[1]"));
		WebDriverWait waitCompOfEmployee = new WebDriverWait(driver,300);
		waitCompOfEmployee.until(ExpectedConditions.visibilityOf(companyOfEmployee)); 
		System.out.println("CompanyName of Jeo Jeo569:"+companyOfEmployee.getText());	
	}
	
	@Ignore
	public void Step9()
	{
		System.out.println("TC3_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		previous_url = current_url;
		
		//Scenario7: Click on the link of that id in the third column
		WebElement link=driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/tbody/tr/td[1]//parent::tr/td[3]/a"));
		WebDriverWait waitLink = new WebDriverWait(driver,3000);
		waitLink.until(ExpectedConditions.visibilityOf(link)); 
		waitLink.until(ExpectedConditions.elementToBeClickable(link));
		link.click();
		Assert.assertNotEquals("Link is not clicked.In the same page.", current_url, driver.getCurrentUrl());	
	}
	
	@Ignore
	public void Step10() throws InterruptedException
	{
		System.out.println("TC10_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		
		List<WebElement> ids=null;
		List<String> originalList=null;
		List<String> sortedList=null;
		//Scenario8: Click on the column header to sort and check if the list is sorted.
		WebElement link = driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/thead/tr/th[1]"));
		WebDriverWait waitLink = new WebDriverWait(driver,3000);
		waitLink.until(ExpectedConditions.visibilityOf(link)); 
		waitLink.until(ExpectedConditions.elementToBeClickable(link));
		link.click();
		System.out.println("Link Clicked...");
		
		//Click each page before these actions
		ids= driver.findElements(By.xpath("//*[@id='page-wrapper']//child::table/tbody//tr/td[1]"));
		//This is the list of ids from column
		originalList=ids.stream().map(s->s.getText()).collect(Collectors.toList());
		//Put it in another list and sort it
		sortedList= originalList.stream().sorted().collect(Collectors.toList());
		System.out.println("Obtained original list..."+originalList);
		System.out.println("Obtained sorted list..."+sortedList);
		//Compare the two list
		Assert.assertTrue("List does not match,names not sorted", originalList.equals(sortedList));	
	}
	
	@Test
	public void C()
	{
		System.out.println("TC11_HandlingDynamicWebTable");
		current_url=getCurrentUrlForHM1();
		
		//Get all the values in that column after sorting
		int pCount=pageCount();
		System.out.println("Obtained the pageCount..");
		
		// Javascript executor
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    
		WebElement currentPage1 =driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/tfoot/tr/td/ul/li[@class='footable-page']["+2+"]")); 
		WebElement currentPage2 =driver.findElement(By.xpath("//*[@id='page-wrapper']//child::table/tfoot/tr/td/ul/li[@class='footable-page']["+3+"]")); 

		System.out.println(currentPage1.getText());
		System.out.println(currentPage2.getText());

		try 
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		// Create an object of actions class and pass reference of WebDriver as a parameter to its constructor. 
		   Actions actions = new Actions(driver); 

		// Call moveToElement() method of actions class to move mouse cursor to a WebElement A. 
		   actions.moveToElement(currentPage1); 
		   actions.clickAndHold(); 
		   actions.release().perform(); 
		   
		   System.out.println("Done");
		   
		   actions.moveToElement(currentPage2);
		   actions.clickAndHold(); 
		   actions.release().perform(); 
		   System.out.println("Done");

	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
