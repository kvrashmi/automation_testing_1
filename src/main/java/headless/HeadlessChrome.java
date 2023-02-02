package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true); 
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://demo.nopcommerce.com/");
		System.out.println("PageTitle:"+driver.getTitle());

	}

}
