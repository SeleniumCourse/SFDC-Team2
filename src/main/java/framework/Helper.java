package framework;

/**
 * Created by Marcelo Ferrufino on 8/26/2015.
 */
public class Helper {

    public static String removeDollarCharToString(String baseString){
        return baseString.replace("$", "").trim();
    }
}