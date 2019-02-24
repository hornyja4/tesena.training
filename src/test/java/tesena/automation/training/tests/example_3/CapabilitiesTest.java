package tesena.automation.training.tests.example_3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CapabilitiesTest {

    @Test
    public void chromeOptionsTest(){
        Map<String, Object> capabilitiesMap = new HashMap<>();
        List<String> options = new ArrayList<>();
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chromedriver.driver", "");

        chromeOptions.setExperimentalOption("prefs", capabilitiesMap);
        chromeOptions.addArguments(options);
        ChromeDriver driver = new ChromeDriver(chromeOptions);
    }

    @Test
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

    @Test
    public void ieOptionsTest(){
        InternetExplorerOptions options = new InternetExplorerOptions();
        Map<String, Object> testCapabilities = new HashMap<>();

        for (Map.Entry<String, Object> capabilities : testCapabilities.entrySet()) {
            options.setCapability(capabilities.getKey(), capabilities.getValue());
        }
        InternetExplorerDriver driver = new InternetExplorerDriver(options);
    }
}
