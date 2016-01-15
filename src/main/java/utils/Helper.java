package utils;

import framework.DriverManager;

import java.util.UUID;

/**
 * Created by Marcelo Ferrufino on 8/26/2015.
 */
public class Helper {

    public static String removeSubstringToString(String subString, String baseString) {
        return baseString.replace(subString, "").trim();
    }

    /**
     * Generates a random string that might be unique adding it as suffix
     *
     * @param base
     * @return String
     */
    public static String generateUniqueString(String base) {
        String uuid = UUID.randomUUID().toString();
        return base + "-" + uuid;
    }

    public static boolean isLoginPage() {
        String baseUrl = removeSubstringToString("https://", DriverManager.getInstance().getBaseUrl());
        String url = removeSubstringToString("https://", DriverManager.getInstance().getDriver().getCurrentUrl());
        String urlSegments[] = url.split("/");

        if ( baseUrl.equalsIgnoreCase(urlSegments[0]) ){
            return true;
        }else {
            return false;
        }
    }
}
