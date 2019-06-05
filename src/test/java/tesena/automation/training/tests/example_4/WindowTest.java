package tesena.automation.training.tests.example_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

public class WindowTest extends SimpleTest {

    @Test
    public void window() {
        WebDriver driver = new ChromeDriver();
        String startingWindow = driver.getWindowHandle();
        System.out.println("Starting window" + startingWindow);
        ((ChromeDriver) driver).executeScript("window.open('','_blank');");
    }
}
