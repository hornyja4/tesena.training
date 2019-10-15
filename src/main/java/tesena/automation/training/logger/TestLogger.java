package tesena.automation.training.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class TestLogger {
    private static ThreadLocal<Logger> threadLocal;

    public static void initLogger(String testName, String destination) {
        ThreadContext.put("testName", testName);
        ThreadContext.put("fileName", destination);
        threadLocal.set(LogManager.getLogger("TestLogger"));
    }

    public static Logger getLogger() {
        Logger logger = threadLocal.get();
        if (logger == null) {
            throw new RuntimeException("Logger must be initialized for current thread.");
        }
        return logger;
    }
}
