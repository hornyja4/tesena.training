package tesena.automation.training.tests.example_4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowTest extends SimpleTest {

    @Test
    public void window() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://sazka.cz");
        String actualWindow = driver.getWindowHandle();
        //System.out.println(actualWindow);
        driver.executeScript("window.open('','_blank');");
        Set<String> widows = driver.getWindowHandles();
        for (String window: widows) {
            if (!actualWindow.equals(window)) {
                driver.switchTo().window(window);
                actualWindow = window;
                break;
            }
        }
        driver.get("http://seznam.cz");
        Thread.sleep(10000);
    }

    public void switchToWindow(String windowName) {

    }
}
