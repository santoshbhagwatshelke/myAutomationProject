package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {
	
	
	@FindBy(xpath="(//a[@class='nav-link'])[7]")private WebElement loginbutton;
	@FindBy(xpath="(//input[@class=\"form-control\"])[1]")private WebElement MoNo;
	@FindBy(xpath="//a[@id='lnk_signup1']")private WebElement siginbutton;
	

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonLoginButtonButton(WebDriver driver)
	{
		utilityClass.UtilityNeoStoxProperty.wait(driver, 2000);
		loginbutton.click();
		utilityClass.UtilityNeoStoxProperty.wait(driver, 2000);
	}
	
	public void EnterMobileNo(WebDriver driver,String uname) 
	{
		MoNo.sendKeys(uname);
		Reporter.log("Sending Mobile No...",true);
		utilityClass.UtilityNeoStoxProperty.wait(driver, 2000);
		
	}
	public void clickonSigninButtonButton(WebDriver driver)
	{
		siginbutton.click();
		Reporter.log("Clicking on signin button...",true);
		utilityClass.UtilityNeoStoxProperty.wait(driver, 2000);
	}
	


}
