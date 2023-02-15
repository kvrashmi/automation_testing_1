package js_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");

		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js= (JavascriptExecutor)driver;
		// Since scrollBy works on distance. So whenever below command is called, page wil be scrolled
				// down vertically
		String command1 = "window.scrollBy(0,100)";
				

		// First scroll vertically
		js.executeScript(command1);
		Thread.sleep(2000);

		// Second scroll vertically
		js.executeScript(command1);
		Thread.sleep(2000);

		// Third scroll vertically
		js.executeScript(command1);
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
