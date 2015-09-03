package framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Marcelo Ferrufino on 9/1/2015.
 */
public class LogManager {

    private static LogManager instance = null;
    private static Logger logger;


    public LogManager() {
        logger = LoggerFactory.getLogger(LogManager.class);
    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    public void addInformationLog(String className, String message) {
        logger.info(className + ": " + message);
    }

    public void addErrorLog(String className, String message, Throwable error) {
        logger.error(className + ": " + message, error);
    }
}
