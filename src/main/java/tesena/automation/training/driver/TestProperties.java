package tesena.automation.training.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestProperties {
    private DesiredCapabilities capabilities;
    private String webUrl;
    private String remoteUrl;
    private String run = "LOCAL";

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    Platform getPlatform(){
        if(capabilities == null){
            throw new RuntimeException("You did not set capabilities.");
        }
        return capabilities.getPlatform();
    }

    String getBrowserName(){
        if(capabilities == null){
            throw new RuntimeException("You did not set capabilities.");
        }
        return capabilities.getBrowserName();
    }

    boolean isRemote(){
        return run.equals("REMOTE");
    }

    public void setRun(String run) {
        this.run = run;
    }

    DesiredCapabilities getCapabilities(){
        return capabilities;
    }

    String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }
}
