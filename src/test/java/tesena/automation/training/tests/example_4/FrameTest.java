package tesena.automation.training.tests.example_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.concurrent.TimeUnit;

public class FrameTest extends SimpleTest {
    private WebDriver driver;

    @Test
    public void frame() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///");
    }

    @AfterTest
    public void reset() {
        driver.quit();
    }
}
