package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class NeoStoxBaseClass 
{
	protected WebDriver driver;
	
	public void LaunchBrowser() throws IOException
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\software tool\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			Reporter.log("Lunching Browser...",true);
			
			driver.get(utilityClass.UtilityNeoStoxProperty.ReadFromPropertyFile("url"));
			
			System.out.println("hii hello for github");
			
	}
}
