package hyperlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1.	Collect all the links present on a web page based on the <a> tag
2.	Send HTTP request for each link
3.	Verify the HTTP response code
4.	Determine if the link is valid or broken based on the HTTP response code
5.	Repeat the process for all links captured with the first step

 */

public class BrokenLinks {
	private static WebDriver driver = null;

	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void BrowserMethods()
	{
		String homePage = "http://www.zlti.com";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		driver.get(homePage);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext())
		{
			url = it.next().getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty())
			{
					System.out.println("URL is either not configured for anchor tag or it is empty");
					continue;
			}
		
			if(!url.startsWith(homePage))
			{
					System.out.println("URL belongs to another domain, skipping it.");
					continue;
			}
		   try 
		   {
			   huc = (HttpURLConnection)(new URL(url).openConnection());
			   huc.setRequestMethod("HEAD");
			   huc.connect();
			   respCode = huc.getResponseCode();
			   if(respCode >= 400)
			   {
				   	System.out.println(url+" is a broken link");
			   }
			   else
			   {
				   System.out.println(url+" is a valid link");
			   }
		  } 
		   catch (MalformedURLException e) 
		   {
			e.printStackTrace();
		   } 
		   catch (IOException e) 
		   {
			e.printStackTrace();
		   }	
		}

		
	}
	
	@After
	public void closeSession()
	{
		driver.close();
		driver.quit();	
	}

}
