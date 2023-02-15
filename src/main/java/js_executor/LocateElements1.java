package js_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElements1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");

		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		// Down casting to WebElement because executeScript return a type of Object
		WebElement element= (WebElement) js.executeScript("return document.getElementById('searchBtn');");
		
		// Getting text
		String text= element.getText();
		System.out.println("Text: "+text);
	}

}
