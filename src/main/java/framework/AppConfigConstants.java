package framework;

import utils.JsonReader;

/**
 * This class provides configuration constants
 *
 */
public final class AppConfigConstants {
	private static JsonReader value = new JsonReader();
	private static String appconfigPath = "\\src\\test\\resources\\data\\appconfig.json";
	public static final String EXCEL_PATH = value.readJsonFile("ExternalFile", "excelPath", appconfigPath);
	public static final String EXCEL_DATA_PROVIDER = value.readJsonFile("ExternalFile", "dataProviderData", appconfigPath);

}
