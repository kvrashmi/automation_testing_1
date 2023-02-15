package js_executor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotPageByPage {
	
	public static String captureScreenShotsForFullPage(WebDriver driver,String testCaseId) throws IOException
	{
		// Defining path and extension of image
		String path= System.getProperty("user.dir")+"/Screenshots/"+testCaseId+"_"+System.currentTimeMillis()+".png";
		System.out.println(path);
		// down casting WebDriver to use getScreenshotAs method.
		TakesScreenshot ts = (TakesScreenshot)driver;
		// capturing screen shot as output type file
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
	   //Copying file from temp folder to desired destination.
		File destImg = new File(path);
		FileUtils.copyFile(srcImg, destImg);
		return path;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.makemytrip.com/");

		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// It returns height of view part. You can say it as page height. When you click on page down key
		// Page scroll by one page. 
		long pageHeight= (long)js.executeScript("return window.innerHeight");
		System.out.println("Page height: "+pageHeight);
		
		// It is how much you can scroll. It is height if you scroll, you will reach to bottom of page.
		long scrollableHeight= (long)js.executeScript("return document.body.scrollHeight");
		System.out.println("Total scrollable height: "+scrollableHeight);
		
		// Finding number of pages. Adding 1 extra to consider decimal part.
		int numberOfPages=(int) (scrollableHeight/pageHeight)+1;
		
		System.out.println("Total pages: "+numberOfPages);
		

		// Now scrolling page by page
		for(int i=0;i<numberOfPages;i++)
		{
			ScreenshotPageByPage.captureScreenShotsForFullPage(driver, "Page_"+(i+1));
			js.executeScript("window.scrollBy(0,"+pageHeight+")");
			Thread.sleep(2000);
		}
	}

}
