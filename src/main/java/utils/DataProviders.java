package utils;

import static framework.AppConfigConstants.EXCEL_DATA_PROVIDER;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;

import utils.ExcelReader;

/**
 * This class contains data providers for tests
 *
 */
public class DataProviders {
	
	/**
	 * Reads data of an excel file.
	 * @return Object[][]
	 * @throws IOException 
	 * @throws BiffException 
	 */
	@DataProvider(name="dataProviderContact")
	public static Object[][] getDataContact() throws BiffException, IOException {
		ExcelReader excelFile = new ExcelReader(EXCEL_DATA_PROVIDER);		
		return excelFile.getObjectValues("Contact");
	}

	@DataProvider(name="dataProviderAccount")
	public static Object[][] getDataAccount() throws BiffException, IOException {
		ExcelReader excelFile = new ExcelReader(EXCEL_DATA_PROVIDER);
		return excelFile.getObjectValues("account");
	}
}
