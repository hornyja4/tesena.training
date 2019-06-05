package tesena.automation.training.tests.example_3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.*;
import tesena.automation.training.test.SimpleTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CapabilitiesTest extends SimpleTest {
    private Map<String, Object> capabilitiesMap = new HashMap<>();
    private ChromeDriver driver;

    @Parameters({"javascriptEnabled"})
    @BeforeSuite
    public void init(@Optional("true") boolean javascriptEnabled) {
        capabilitiesMap.put("javascriptEnabled", javascriptEnabled);
    }

    @Test
    public void chromeOptionsTest() {
        List<String> options = new ArrayList<>();
        options.add("--headless");
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("prefs", capabilitiesMap);
        chromeOptions.addArguments(options);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://seznam.cz");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//a[text()='Prodejci']"));
        element.click();
    }

    @AfterTest
    public void reset() {
        File screen = driver.getScreenshotAs(OutputType.FILE);
        try {
            File directory = new File("target\\images");
            directory.mkdirs();
            FileUtils.copyFile(screen, new File("target\\images\\screen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void firefoxOptionsTest() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        options.setProfile(firefoxProfile);
        FirefoxDriver driver = new FirefoxDriver(options);
    }

    @Test
    public void ieOptionsTest() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        InternetExplorerDriver driver = new InternetExplorerDriver(options);
    }
}
