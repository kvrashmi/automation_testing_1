package homework;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Scenario: Users will be able to add deposit
1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
2. Enter username: demo@techfios.com 
3. Enter password: abc123
4. Click login button
5. Click on Bank & Cash button
6. Click on New Account button 
7. Fill out the Add New Account form
8. Click on submit button
9. Visually check if the account has been created
Visually check to make sure the deposit posted
*/
public class HomeWork1 {
	
	static WebDriver driver;
	static String optGroupUrl="http://www.techfios.com/billing/?ng=admin/";
	
	public static String getCurrentUrlForHM1()
	{
		String current_url=driver.getCurrentUrl();
		System.out.println("current url:"+current_url);
		return current_url;
	}
	
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(optGroupUrl);
	}
	
	
	@Test
	public void Step1() 
	{
		System.out.println("TC1_Login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String current_url=HomeWork1.getCurrentUrlForHM1();
		
		//username: /html/body/div/div/div/form/div[1]/input
		WebElement username = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
		System.out.println("Identified username...");
		
		//password: //input[@id='password']
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		System.out.println("Identified password...");
		
		username.sendKeys("demo@techfios.com");
		password.sendKeys("abc123");
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		if(loginBtn.isDisplayed())
		{
			loginBtn.submit();
		}
		System.out.println("Login Button Clicked...");
	}
	
	
	@Test
	public void Step2()
	{
		System.out.println("TC2_ClickBankAndCashBtn");
		String current_url=HomeWork1.getCurrentUrlForHM1();
		// Bank and Cash: /html/body/section/div/nav/div/ul/li[10]/a/span[1]
		//*[@id="side-menu"]/li[10]/a/span[1]
		if(current_url.equals("https://techfios.com/billing/?ng=dashboard/"))
		{
			WebElement bankAndCash = driver.findElement(By.xpath("/html/body/section/div/nav/div/ul/li[10]/a/span[1]"));
			System.out.println(bankAndCash.getText());
			bankAndCash.click();
		}
		
	}
	
	@Test
	public void Step3()
	{
		System.out.println("TC3_ClicklNewButton");
		//New Account : /html/body/section/div/nav/div/ul/li[10]/ul/li[1]/a[@href='https://techfios.com/billing/?ng=accounts/add/']
		WebElement newAccount = driver.findElement(By.xpath("/html/body/section/div/nav/div/ul/li[10]/ul/li[1]/a"));
		newAccount.click();
	}
	
	@Test
	public void Step4()
	{
		System.out.println("TC4_FillFormAndSubmit");
		String current_url=HomeWork1.getCurrentUrlForHM1();
		// Bank and Cash: /html/body/section/div/nav/div/ul/li[10]/a/span[1]
		//*[@id="side-menu"]/li[10]/a/span[1]
		if(current_url.equals("https://techfios.com/billing/?ng=accounts/add/"))
		{
			WebElement accountTitle = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[1]/input"));
			accountTitle.sendKeys("Rashmi1");
			WebElement description = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[2]/input"));
			description.sendKeys("Payment Account");
			WebElement initialBalance = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[3]/input"));
			initialBalance.sendKeys("1000");
			WebElement accountNumber = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[4]/input"));
			accountNumber.sendKeys("10001");
			WebElement contactPerson = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[5]/input"));
			contactPerson.sendKeys("AccountMgr");
			WebElement phone = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[6]/input"));
			phone.sendKeys("4084065112");
			WebElement internetBankingUrl= driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/div[7]/input"));
			internetBankingUrl.sendKeys("citibank.com");
			WebElement createAccount = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/form/button"));
			createAccount.submit();
			
		}
	}
	
	
	@AfterClass
	public static void tearDown()
	{
		//driver.close();
		//driver.quit();
	}
	
}
