package pomClasses;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import utilityClass.UtilityNeoStoxProperty;
public class HomePage {
	
	@FindBy(xpath="(//span[@class='righttopmenu1'])[1]")private WebElement username;
	@FindBy(xpath="(//span[@class='righttopmenu1'])[2]/span")private WebElement fundsButton;
	@FindBy(xpath="(//div[@class='col-lg-12 text-center']/a)[5]")private WebElement okbutton;
	@FindBy(xpath="(//a[text()='Close'])[5]")private WebElement closebutton;
	@FindBy(xpath="//a[@id='lnk_logout']")private WebElement logoutbutton;
	@FindBy(xpath="(//span[@class='righttopmenu1'])[2]/span")private WebElement myBalance;


	public HomePage(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}
	
	public void clickOnPopup(WebDriver driver) throws InterruptedException
	{
		UtilityNeoStoxProperty.wait(driver, 50000);
		Thread.sleep(5000);
		okbutton.click();
		UtilityNeoStoxProperty.wait(driver, 50000);
		closebutton.click();
		UtilityNeoStoxProperty.wait(driver, 50000);
		Reporter.log("handling Popup...",true);
		
	}
	
	public String actualNeoUsername(WebDriver driver) 
	{
		
		String actualusername = username.getText();
		return actualusername;
	}
	public void ValidateFunds(WebDriver driver)
	{
		UtilityNeoStoxProperty.wait(driver, 1000);
		String fund = myBalance.getText();
		System.out.println("My Total Balance is: "+fund);
	}
	public void LogoutOutNeostox(WebDriver driver)
	{
		UtilityNeoStoxProperty.wait(driver, 20000);
		username.click();
		Reporter.log("Logged out sucussfully.....",true);
		UtilityNeoStoxProperty.wait(driver, 20000);
		logoutbutton.click();
		
	}
	public void CloseB(WebDriver driver)
	{
		UtilityNeoStoxProperty.wait(driver, 20000);
		driver.close();
	}
	
	
}
