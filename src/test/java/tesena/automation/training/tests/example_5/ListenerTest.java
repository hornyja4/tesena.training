package tesena.automation.training.tests.example_5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(NewListener.class)
public class ListenerTest extends SimpleTest {
    static ChromeDriver driver;

    @Test
    public void testWithListener() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void reset() {
        driver.quit();
    }
}
