package cookies;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesLearning {
	public static WebDriver driver;
	WebElement elementLocator = null;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void executeTest()
	{
		driver.get("https://www.google.com");
		Set<Cookie> cookies = driver.manage().getCookies();
		
		for(Cookie c:cookies)
		{
			System.out.println("=================================");
			System.out.println("Cookie Name:"+c.getName());
			System.out.println("Cookie Value:"+c.getValue());
			System.out.println("Cookie Domain:"+c.getDomain());
			System.out.println("Cookie Path:"+c.getPath());
			System.out.println("Cookie Expiry Date:"+c.getExpiry());
			System.out.println("=================================");
			
		}
		
		//Add cookie - create cookie object with name and value
		Cookie cookie1 = new Cookie("tes1","val1");
		Cookie cookie2 = new Cookie("tes2","val2");
		//then add them
		driver.manage().addCookie(cookie1);
		driver.manage().addCookie(cookie2);
		
		Cookie cookie3 = driver.manage().getCookieNamed("tes2");
		System.out.println("=================================");
		System.out.println("Cookie Name:"+cookie3.getName());
		System.out.println("Cookie Value:"+cookie3.getValue());
		System.out.println("Cookie Domain:"+cookie3.getDomain());
		System.out.println("Cookie Path:"+cookie3.getPath());
		System.out.println("Cookie Expiry Date:"+cookie3.getExpiry());
		System.out.println("=================================");
		
		//deleteCookieNamed: pass the name of the cookie
		driver.manage().deleteCookieNamed("tes2");
		//deleteCookie: pass the cookie object
		driver.manage().deleteCookie(cookie2);
		
		//Clearing Cache and Cookies
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.localStorage.setItem('bgcolor', 'red');");
		js.executeScript("console.log('GetItem:'+window.localStorage.getItem('bgcolor'));");
		js.executeScript("window.localStorage.clear();");
		js.executeScript("console.log('GetItem:'+window.localStorage.getItem('bgcolor'));");
		js.executeScript("window.sessionStorage.clear();");
		driver.manage().deleteAllCookies();
		
		//Check if cookies exist
		Set<Cookie> cookies1 = driver.manage().getCookies();
		
		for(Cookie c:cookies1)
		{
			System.out.println("=================================");
			System.out.println("Cookie Name:"+c.getName());
			System.out.println("Cookie Value:"+c.getValue());
			System.out.println("Cookie Domain:"+c.getDomain());
			System.out.println("Cookie Path:"+c.getPath());
			System.out.println("Cookie Expiry Date:"+c.getExpiry());
			System.out.println("=================================");
			
		}

	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();	
	}
}
