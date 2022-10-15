package iframes;

import java.util.List;

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

public class IFrameLearning {
	
	static WebDriver driver;
	static String optGroupUrl="file:///Users/rashmikanduluvavikraman/selenium-workspace/crm/src/main/java/iframes/iframe.html";
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	}
	
	@Before
	public void startSession() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(optGroupUrl);
	}
	
	@Test
	public void getTheNumberOfFrames1()
	{
		System.out.println("Method1 to get the number of iFrames:");
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Long numberOfFrames= (Long) exe.executeScript("return window.length");
		System.out.println("Number of frames:"+numberOfFrames);
	}
	
	@Test
	public void getTheNumberOfFrames2()
	{
		System.out.println("Method1 to get the number of iFrames:");
		int iFramesCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of frames:"+iFramesCount);
	}
	
	@Test
	public void switchToFrameBy1Index()
	{
		driver.switchTo().frame(0);
	
	}
	
	@Test
	public void switchToFrameBy2Name()
	{
		driver.switchTo().frame("iframe2");
	}
	
	@Test
	public void switchToFrameBy3Id()
	{
		driver.switchTo().frame("IF1");
	}
	
	@Test
	public void switchToFrameBy4Element()
	{
		WebElement elem = driver.findElement(By.xpath("//iframe[@id='iframe1']"));
		driver.switchTo().frame(elem);
		System.out.println("Switching to default content:");
		driver.switchTo().defaultContent();
	}
	
	
	
	@After
	public void closeSession()
	{
		driver.close();
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.quit();
	}
	

}
