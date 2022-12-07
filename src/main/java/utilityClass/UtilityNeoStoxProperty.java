package utilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNeoStoxProperty {

	public static String ReadFromPropertyFile(String key) throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream myFile = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\TestNg Project\\Neostoxproperty.properties");
		
		prop.load(myFile);
		
		String value = prop.getProperty(key);
		
		return value;
	}

	 public static void ScreenShootMethod(WebDriver driver,String name) throws IOException 
	 {
		File src = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\HP\\Pictures\\ScreenShot By Selinium\\"+name+".jpg");
	
		FileHandler.copy(src, dest);
		Reporter.log("Taking Screenshot sucussfully.....",true);

	 }
	 
	 public static void wait(WebDriver driver,int time)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	 }
	
}
