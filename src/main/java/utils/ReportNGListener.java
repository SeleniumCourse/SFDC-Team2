package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportNGListener implements ITestListener {

	@Override
	public void onStart(ITestContext result) {
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		//Folder where the screenshots for the report would be saved
		String filePath = System.getProperty("user.dir") + "/test-output/html/screenshots/";
		String failureImageFileName;
		
		//If the test case has a data provider
		if(result.getMethod().toString().contains("java.lang")) {
			
			//The name of the file would be the name of the test case plus the name of the first parameter
			failureImageFileName =  result.getName() + "_" + result.getParameters()[0] + ".png"; 
		} else {
			
			//The name of the file would be the name of the test case 
			failureImageFileName =  result.getName() + ".png"; 
		}
		
		//Taking the screenshot
		UIMethods.takeScreenShot(filePath, failureImageFileName);
		
		//Adding the screenshot to the report
		Reporter.log("<a href=\"" + filePath + failureImageFileName 
				+ "\"><img src=\"file:///" + filePath + failureImageFileName 
				+ "\" alt=\"\"" + "height='100' width='100'/> " + "<br />"); 
		Reporter.setCurrentTestResult(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
		
	@Override
	public void onFinish(ITestContext context) {
		
	}	
}
