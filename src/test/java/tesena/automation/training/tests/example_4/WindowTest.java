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
        Map<String, String> windowMap = new HashMap<>();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String startingWindow = driver.getWindowHandle();
        windowMap.put("starting", startingWindow);
        System.out.println("Starting window" + startingWindow);
        driver.executeScript("window.open('','_blank');");
        Set<String> windows = driver.getWindowHandles();
        String newWindow = "";
        for(String window: windows) {
            if (!windowMap.containsValue(window)) {
                windowMap.put("new", window);
            }
        }
        driver.switchTo().window(windowMap.get("new"));
        driver.get("http://demo.redmine.org");
        Thread.sleep(30000);
    }
}
