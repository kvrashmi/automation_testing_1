package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless"); 
		WebDriver driver = new FirefoxDriver(options);
		
		driver.get("http://demo.nopcommerce.com/");
		System.out.println("PageTitle:"+driver.getTitle());
		
	}

}
