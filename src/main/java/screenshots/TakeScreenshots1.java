package screenshots;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshots1 {
	WebDriver driver=null ;
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}



	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void BrowserMethods()
	{
		driver.get("https://www.browserstack.com");
		//Call take screenshot function
		try {
			TakeScreenshots1.takeSnapShot(driver,"//Users//rashmikanduluvavikraman//Desktop//Scr.png" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} ; 


	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();	
	}


}
