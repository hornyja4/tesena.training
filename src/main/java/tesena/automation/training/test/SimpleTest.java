package tesena.automation.training.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import tesena.automation.training.listeners.MyListener;

@Listeners(MyListener.class)
public class SimpleTest {
    protected ChromeDriver driver;

    @BeforeSuite
    public void processDriverSettings() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\horny\\Desktop\\automation\\automationtraining\\src\\main\\resources\\files\\chromedriver_78.exe");
        System.setProperty("webdriver.gecko.driver", "");
        System.setProperty("webdriver.firefox.bin", "");
        System.setProperty("webdriver.ie.driver", "");
    }

    @AfterClass
    public void reset() {
        if (driver == null) {
            return;
        }
        driver.quit();
    }
}
