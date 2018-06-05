package tesena.automation.training.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PropertiesManager;

@Listeners({TestListener.class})
public class RedmineTest {

    @Parameters({"browser", "platform", "run", "webUrl", "remoteUrl"})
    @BeforeClass
    public void init(@Optional("CHROME") String browser,
                     @Optional("WINDOWS") String platform,
                     @Optional("LOCAL") String run,
                     @Optional("http://demo.redmine.org") String webUrl,
                     @Optional("http://localhost:4444/wd/hub") String remoteUrl) {
        PropertiesManager.setRun(run);
        PropertiesManager.setRemoteUrl(remoteUrl);
        PropertiesManager.setWebUrl(webUrl);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setPlatform(Platform.valueOf(platform));
        PropertiesManager.setCapabilities(capabilities);
    }

    @AfterClass
    public void reset() {
        DriverManager.getInstance().quit();
    }
}
