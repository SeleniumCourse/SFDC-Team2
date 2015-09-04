package utils;

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

}
