package windows_operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class WindowOperations1 {
	
	public static WebDriver driver1;
	public static WebDriver driver2;

	static String URL1 = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
	static String URL2 = "https://demoqa.com/buttons";
	
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
		driver2 = new ChromeDriver();
		driver2.manage().deleteAllCookies();
		driver2.manage().window().maximize();
	}
	
	
	@Test
	public void a_OpenWindowInNewTab()
	{
		try {
		driver1.get("https://www.google.com/");
		driver1.manage().window().maximize();
		WebElement elementLocator = driver1.findElement(By.linkText("About"));
		String hrefLink = elementLocator.getAttribute("href");
		((JavascriptExecutor) driver1).executeScript("window.open('"+hrefLink+"','_blank');");
		Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void a_OpenWindowInNewBlankWindow()
	{
		try {
		driver1.get("https://www.google.com/");
		driver1.manage().window().maximize();
		WebElement elementLocator = driver1.findElement(By.linkText("About"));
		String hrefLink = elementLocator.getAttribute("href");
		driver2.get(hrefLink);
		Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	@Test
	public void openMultipleWindowsAndSwitch()
	{
		
		try 
		{
			driver1.get("https://www.yahoo.com");
			String parentWindow = driver1.getWindowHandle();
			System.out.println("ParentWindowTitle:"+driver1.getTitle());
			
			ArrayList<String> pages = new ArrayList<String>();
			pages.add("https://www.stackoverflow.com");
			pages.add("https://www.flipkart.com");
			
			for(int i=0;i<pages.size();i++) {
				((JavascriptExecutor) driver1).executeScript("window.open('"+pages.get(i)+"','_blank');");
			}
			Thread.sleep(10000);
			driver1.switchTo().window(parentWindow);
			
			Set<String> childWindows = driver1.getWindowHandles();
			Iterator<String> iChild = childWindows.iterator();
			while(iChild.hasNext())
			{
				driver1.switchTo().window(iChild.next());
				System.out.println("ChildWindowTitle:"+driver1.getTitle());
			}
			driver1.switchTo().window(parentWindow);

		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		} 	
			 		
	}
	
	/*
	@Test
	public void C()
	{
		//Selenium 4.0
		//Open new window
		
		driver1.get("https://www.google.com/");
		// Opens a new window and switches to new window
		//driver1.switchTo().newWindow(WindowType.WINDOW);
		// Opens LambdaTest homepage in the newly opened window
		driver1.navigate().to("https://www.lambdatest.com/");
		//Open new tab

		driver1.get("https://www.google.com/");
		// Opens a new window and switches to new window
		//driver1.switchTo().newWindow(WindowType.TAB);
		// Opens LambdaTest homepage in the newly opened tab
		driver1.navigate().to("https://www.lambdatest.com/");
		
	}
	*/
	@After
	public void closeSession()
	{
		driver1.close();
		driver2.close();
		driver1.quit();
		driver2.quit();
		
	}
	

	

}
