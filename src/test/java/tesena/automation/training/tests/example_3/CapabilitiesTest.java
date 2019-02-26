package tesena.automation.training.tests.example_3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import tesena.automation.training.tests.example_4.ParentTest;
import tesena.automation.training.tests.example_4.SimpleListener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Listeners(SimpleListener.class)
public class CapabilitiesTest {
    Map<String, Object> capabilitiesMap = new HashMap<>();
    ChromeDriver driver;

    @Parameters({"javascriptEnabled"})
    @BeforeSuite
    public void init(@Optional("true") boolean javascriptEnabled) {
        capabilitiesMap.put("javascriptEnabled", javascriptEnabled);
    }

    @Test
    public void chromeOptionsTest(){
        List<String> options = new ArrayList<>();
        options.add("--headless");
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

        chromeOptions.setExperimentalOption("prefs", capabilitiesMap);
        chromeOptions.addArguments(options);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.seznam.cz/");
        throw new RuntimeException("");
    }

    @AfterTest
    public void reset() {
        File screen = driver.getScreenshotAs(OutputType.FILE);
        try {
            File directory = new File("target\\images");
            directory.mkdirs();
            System.out.println(directory.getPath());
            FileUtils.copyFile(screen,  new File("target\\images\\screen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    //@Test
    public void firefoxOptionsTest(){
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        Map<String, Object> testCapabilities = new HashMap<>();
        Map<String, String> preferences = new HashMap<>();
        Map<String, String> profile = new HashMap<>();

        System.setProperty("webdriver.gecko.driver", "");
        System.setProperty("webdriver.firefox.bin", "");

        for (Map.Entry<String, Object> capability : testCapabilities.entrySet()) {
            options.setCapability(capability.getKey(), capability.getValue());
        }
        for (Map.Entry<String, String> capabilities : preferences.entrySet()) {
            options.addPreference(capabilities.getKey(), capabilities.getValue());
        }
        for (Map.Entry<String, String> capabilities : profile.entrySet()) {
            firefoxProfile.setPreference(capabilities.getKey(), capabilities.getValue());
        }
        options.setProfile(firefoxProfile);
        FirefoxDriver driver = new FirefoxDriver(options);
    }

    //@Test
    public void ieOptionsTest(){
        InternetExplorerOptions options = new InternetExplorerOptions();
        Map<String, Object> testCapabilities = new HashMap<>();

        for (Map.Entry<String, Object> capabilities : testCapabilities.entrySet()) {
            options.setCapability(capabilities.getKey(), capabilities.getValue());
        }
        InternetExplorerDriver driver = new InternetExplorerDriver(options);
    }
}
