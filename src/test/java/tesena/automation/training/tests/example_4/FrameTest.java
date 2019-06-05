package tesena.automation.training.tests.example_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

public class FrameTest extends SimpleTest {
    private WebDriver driver;

    @Test
    public void frame() {
        driver = new ChromeDriver();
        driver.get("file:///...");
    }

    @AfterTest
    public void reset() {
        driver.quit();
    }

}
