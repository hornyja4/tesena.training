package tesena.automation.training.test;

import org.testng.annotations.BeforeSuite;

public class SimpleTest {

    @BeforeSuite
    public void processDriverSettings() {
        System.setProperty("webdriver.chrome.driver", "");
        System.setProperty("webdriver.gecko.driver", "");
        System.setProperty("webdriver.firefox.bin", "");
        System.setProperty("webdriver.ie.driver", "");
    }
}
