package utils;

import static  framework.AppConfigConstants.EXCEL_PATH;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * This class provides a methods to read .xls files
 *
 */
public class ExcelReader {
	private Workbook workBook;
	
	/**
	 * This method sets the path when the file is available
	 * @param path
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public ExcelReader(String path) throws BiffException, IOException {
			workBook = Workbook.getWorkbook(new File(System.getProperty("user.dir") + EXCEL_PATH + path));
	}
	
	/**
	 * This method reads a excel file
	 * @param nameSheet: Name of Sheet
	 * @return Matrix with all data of a sheet
	 */
	public Object[][] getObjectValues(String nameSheet) {
		Sheet sheet = workBook.getSheet(nameSheet);
		Object[][] values = new Object[sheet.getRows() - 1][sheet.getColumns()];
		for (int i = 1; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				values[i - 1][j] = sheet.getCell (j, i).getContents();
			}
		}
		return values;
	}
}
