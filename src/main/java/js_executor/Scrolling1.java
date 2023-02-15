package js_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/");

		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String command1 = "window.scrollTo(0,100)";
		String command2 = "window.scrollTo(0,200)";
		String command3 = "window.scrollTo(0,300)";

		// First scroll vertically
		js.executeScript(command1);
		Thread.sleep(2000);

		// Second scroll vertically
		js.executeScript(command2);
		Thread.sleep(2000);

		// Third scroll vertically
		js.executeScript(command3);
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
