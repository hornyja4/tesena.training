package tesena.automation.training.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tesena.automation.training.driver.PropertiesManager;

public class RedmineTest {

    @Parameters({"browser", "run"})
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

}
