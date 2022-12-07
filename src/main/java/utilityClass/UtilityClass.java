package utilityClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	//Sending data directly to the field by sendkeys
	 public static String ExcelMethod(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	 {
		File myFile = new File("C:\\Users\\HP\\Downloads\\software tool\\Excel_Sheet.xlsx");

		Sheet MySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
		 
		    String value = MySheet.getRow(row).getCell(cell).getStringCellValue();
		     return value;
		}
	 
	 public static void ScreenShootMethod(WebDriver driver,String name) throws IOException 
	 {
		File src = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\HP\\Pictures\\ScreenShot By Selinium\\"+name+".jpg");
	
		FileHandler.copy(src, dest);

	 }
	 
	 public static void ScroolingMethod(WebDriver driver,WebElement element)
			{
				JavascriptExecutor jc = (JavascriptExecutor)driver;
				jc.executeScript("arguments[0].scrollIntoView()",element);
			}
		 
	 //Fetching data from the excel sheet
	 public static void ExcelSheetMethod(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	 {
			File myFile = new File("C:\\Users\\HP\\Downloads\\software tool\\Excel_Sheet.xlsx");

	        Sheet MySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
	        
	       String data = MySheet.getRow(row).getCell(cell).getStringCellValue();
	 
	       System.out.println(data);
	 }
	 public static void wait(WebDriver driver,int time)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	 }
	 
}
