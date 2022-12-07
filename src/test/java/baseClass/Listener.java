package baseClass;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilityClass.UtilityNeoStoxProperty;
public class Listener extends NeoStoxBaseClass implements ITestListener
{

	
	public void onTestSuccess(ITestResult result) 
	{
		String TCname = result.getName();
		Reporter.log("Test "+TCname+" is completed successfully", true);
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String TCname = result.getName();
		Reporter.log("Test "+TCname+" is failed please have a look again",true);
		try {
			UtilityNeoStoxProperty.ScreenShootMethod(driver, TCname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Test "+TCname+" failed, taken screenshot",true);
		
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		String TCname = result.getName();
		Reporter.log("Test "+TCname+" is skipped please retry", true);		
	}

}
