package js_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPageByPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Get height of page
		long pageHeight = (long)(js.executeScript("return window.innerHeight"));
		System.out.println("PageHeight:"+pageHeight);
		
		//Get the scrollable height
		long scrollableHeight = (long)(js.executeScript("return document.body.scrollHeight"));
		System.out.println("Scrollable Height:"+scrollableHeight);
		
		//Total number of pages 
		int pageCount = (int)(scrollableHeight/pageHeight)+1;
		System.out.println("Total Pages:"+pageCount);
		
		// Now scrolling page by page
		for(int i=0;i<pageCount;i++)
		{
			js.executeScript("window.scrollBy(0,"+pageHeight+")");
			Thread.sleep(2000);
		}
	}

}
