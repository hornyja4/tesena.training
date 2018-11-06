package tesena.automation.training.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.TestProperties;

public class RedmineTest {
    protected DriverManager driverManager;

    @Parameters({"browser", "platform", "run", "webUrl", "remoteUrl"})
    @BeforeClass
    public void init(@Optional("CHROME") String browser,
                     @Optional("WINDOWS") String platform,
                     @Optional("LOCAL") String run,
                     @Optional("http://demo.redmine.org") String webUrl,
                     @Optional("http://localhost:4444/wd/hub") String remoteUrl) {
        TestProperties properties = new TestProperties();
        properties.setRemoteUrl(remoteUrl);
        properties.setWebUrl(webUrl);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setPlatform(Platform.valueOf(platform));
        properties.setCapabilities(capabilities);
        driverManager = new DriverManager(properties);
    }

    @AfterClass
    public void reset() {
        //driverManager.quit();
    }
}
