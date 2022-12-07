package testClasses;


import baseClass.NeoStoxBaseClass;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.PinPage;
import utilityClass.*;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(baseClass.Listener.class)
public class TestClass extends NeoStoxBaseClass {
	
	LoginPage login;
	PinPage pin;
	HomePage home;
	
	
	@BeforeClass
	  public void openBrowser() throws IOException 
	  {
		LaunchBrowser();

		login = new LoginPage(driver);
		pin = new PinPage(driver);
		home = new HomePage(driver);
		
	  }
	@BeforeMethod
        public void LoginToNeostox() throws IOException, InterruptedException 
		 {
			login.clickonLoginButtonButton(driver);
			login.EnterMobileNo(driver, UtilityNeoStoxProperty.ReadFromPropertyFile("mobile"));
			login.clickonSigninButtonButton(driver);
			
			pin.EnterPassword(driver, UtilityNeoStoxProperty.ReadFromPropertyFile("password"));
			pin.clickonSumbitButton(driver);
			
			
	  }
    @Test
        public void ValidateUsername() throws IOException, InterruptedException 
     {
    	home.clickOnPopup(driver);
		 Assert.assertEquals(home.actualNeoUsername(driver), UtilityNeoStoxProperty.ReadFromPropertyFile("username"),"Actual Username and Expected Username are Not Matching...TC FAILED..");
			Reporter.log("Actual Username and Expected Username are Matching...TC PASSED..",true);
			  UtilityClass.ScreenShootMethod(driver, home.actualNeoUsername(driver));

     }
  
    @Test(priority = 1)
    public void ValidateFunds() throws IOException 
 {
	 home.ValidateFunds(driver);
	  UtilityClass.ScreenShootMethod(driver, "MyFund");

 }
    @AfterMethod
  public void Logout() 
  {
	  home.LogoutOutNeostox(driver);
	  Reporter.log("Close Browser sucussfully.....",true);
  }

  @AfterClass
  public void CloseBrowser(WebDriver driver) 
  {
	  driver.close();
	  Reporter.log("Close Browser sucussfully.....",true);
	  
  }

}
