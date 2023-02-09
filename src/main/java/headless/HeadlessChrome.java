package headless;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class HeadlessChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true); 
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://demo.nopcommerce.com/");
		System.out.println("PageTitle:"+driver.getTitle());
		
		// You should set window size for better resolution and screen capture
		options.addArguments("window-size=1200x600");
				
		ChromeDriver browser = new ChromeDriver(options);
		browser.get("https://chromedriver.chromium.org/downloads");
		
		// Capturing screenshot
		File file = browser.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File(System.getProperty("user.home")+"\\Downloads\\chromedriver_win32 (4)\\ss.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		browser.close();

	}

}
