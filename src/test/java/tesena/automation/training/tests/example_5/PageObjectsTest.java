package tesena.automation.training.tests.example_5;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PropertiesManager;
import tesena.automation.training.factory.POFactory;
import tesena.automation.training.objects.DefaultPage;

public class PageObjectsTest {
    private Logger logger = LogManager.getLogger();

    @BeforeClass
    public void init() {
        PropertiesManager.setRun("LOCAL");
        PropertiesManager.setWebUrl("http://demo.redmine.org");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("CHROME");
        capabilities.setPlatform(Platform.WINDOWS);
        PropertiesManager.setCapabilities(capabilities);
    }

    @Test
    public void loginTest() {
        DefaultPage defaultPage = POFactory.createObject();
    }

    @AfterClass
    public void reset() {
        DriverManager.getInstance().quit();
    }

}
