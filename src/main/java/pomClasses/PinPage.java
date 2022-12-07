package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PinPage {
	
	@FindBy(xpath="//input[@id='txt_accesspin']")private WebElement pwd;
	@FindBy(xpath="//a[text()='Submit']")private WebElement sumbitButton;

	public  PinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterPassword(WebDriver driver,String pass) throws InterruptedException
	{
		pwd.sendKeys(pass);
		Reporter.log("Sending Password No...",true);
		utilityClass.UtilityNeoStoxProperty.wait(driver, 2000);
		Thread.sleep(2000);
	}
	public void clickonSumbitButton(WebDriver driver)
	{
		sumbitButton.click();
		Reporter.log("Clicking on submit button..",true);
		utilityClass.UtilityNeoStoxProperty.wait(driver, 3000);
	}

}
