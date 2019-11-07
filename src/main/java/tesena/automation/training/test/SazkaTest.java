package tesena.automation.training.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.TestProperties;
import tesena.automation.training.listeners.MyListener;

@Listeners(MyListener.class)
public class SazkaTest {
    protected DriverManager driverManager;

    @Parameters({"browser", "platform", "run", "webUrl", "remoteUrl"})
    @BeforeClass
    public void init(@Optional("CHROME") String browser,
                     @Optional("WINDOWS") String platform,
                     @Optional("LOCAL") String run,
                     @Optional("http://sazka.cz") String webUrl,
                     @Optional("http://localhost:4444/wd/hub") String remoteUrl) {
        TestProperties properties = new TestProperties();
        properties.setRemoteUrl(remoteUrl);
        properties.setWebUrl(webUrl);
        properties.setRun(run);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setPlatform(Platform.valueOf(platform));
        properties.setCapabilities(capabilities);
        driverManager = new DriverManager(properties);
    }

    @AfterClass
    public void reset() {
        driverManager.quit();
    }
}
