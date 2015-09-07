package framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Juan Pablo Montano on 6/27/2015.
 */
public class Environment {

    private static Environment environment;
    private Properties properties;

    private Environment() {
        readFile();
    }

    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    public void readFile() {
        File file = new File("gradle.properties");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties = new Properties();
            properties.load(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEnv(String key) {
        String env = System.getProperty(key);
        if (env == null) {
            env = properties.getProperty(key);
        }
        return env;
    }

    public String getPrimaryUser() {
        return getEnv("primaryUserName");
    }

    public String getPrimaryPassword() {
        return getEnv("primaryUserPassword");
    }

    public String getBrowser(){
        return getEnv("browser");
    }

    public String getGroups() {return getEnv("groups");}

    public String getDisplayName() {
        return getEnv("displayName");
    }

    public String getMode() { return getEnv("mode"); }

    public String getUserName() { return getEnv("userName"); }

    public String getKey() { return getEnv("key"); }

    public String getRemoteBrowser() { return getEnv("remoteBrowser"); }

    public String getRemotePlatform() { return getEnv("remotePlatform"); }

    public String getRemoteVersion() { return getEnv("remoteVersion"); }
}
