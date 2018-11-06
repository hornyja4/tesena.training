package tesena.automation.training.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class TestLogger {
    private static Logger logger;

    public static void initLogger(String testName, String destination) {
        ThreadContext.put("testName", testName);
        ThreadContext.put("fileName", destination);
        logger = LogManager.getLogger("TestLogger");
    }

    public static Logger getLogger() {
        return logger;
    }
}
