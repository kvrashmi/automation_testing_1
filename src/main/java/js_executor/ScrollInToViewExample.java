package js_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollInToViewExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");
		
		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// This element is down of the web page
		WebElement wordpresslink= driver.findElement(By.xpath("//p[text()='© 2023 MAKEMYTRIP PVT. LTD.']"));

		// This command will bring element in to view but will not align with top of browser and further scroll down is not possible.
		//js.executeScript("arguments[0].scrollIntoView(true);", wordpresslink);
		
		// This command will bring element in to view and will align with bottom of browser which is not possible to do.
		// In this case no scroll will be performed.  
		js.executeScript("arguments[0].scrollIntoView(false);", wordpresslink);
				
	}

}
