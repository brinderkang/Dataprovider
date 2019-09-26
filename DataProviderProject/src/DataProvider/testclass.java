package DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testclass {
	
	static WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Brinder\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		
	}
	@DataProvider
	public Iterator<Object[]> testdata()
	{
		ArrayList<Object[]> data=testutil.gettestdata();
		return data.iterator();
	}
	
	
	
	@Test(dataProvider="testdata")
	public void Login(String username,String password) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(username);
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath("//input[@value='Next']"));
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='login-signin']")).sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver.quit();
	}

}
