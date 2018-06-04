package tesena.automation.training.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PropertiesManager {
    private static DesiredCapabilities capabilities;
    private static String webUrl;
    private static String remoteUrl;
    private static String run = "LOCAL";

    public static void setCapabilities(DesiredCapabilities capabilities) {
        PropertiesManager.capabilities = capabilities;
    }

    public static Platform getPlatform(){
        if(capabilities == null){
            throw new RuntimeException("You did not set capabilities.");
        }
        return capabilities.getPlatform();
    }

    public static String getBrowserName(){
        if(capabilities == null){
            throw new RuntimeException("You did not set capabilities.");
        }
        return capabilities.getBrowserName();
    }

    public static boolean isRemote(){
        return run.equals("REMOTE");
    }

    public static void setRun(String run) {
        PropertiesManager.run = run;
    }

    public static DesiredCapabilities getCapabilities(){
        return capabilities;
    }

    public static String getWebUrl() {
        return webUrl;
    }

    public static void setWebUrl(String webUrl) {
        PropertiesManager.webUrl = webUrl;
    }

    public static String getRemoteUrl() {
        return remoteUrl;
    }

    public static void setRemoteUrl(String remoteUrl) {
        PropertiesManager.remoteUrl = remoteUrl;
    }
}
