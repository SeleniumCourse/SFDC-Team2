package utils;

import java.io.File;
import java.io.IOException;

import framework.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class UIMethods {	

	/** 
	 * This method takes screenshots 
	 * @param filePath 
	 * @param fileName 
	 * @throws IOException 
	 */ 
	public static void takeScreenShot(String filePath, String fileName) throws IOException { 
		try { 
			File scrFile = ((TakesScreenshot) DriverManager.getInstance().getDriver())
					.getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File(filePath + fileName)); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}
