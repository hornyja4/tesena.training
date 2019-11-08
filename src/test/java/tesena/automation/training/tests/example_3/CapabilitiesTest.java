package tesena.automation.training.tests.example_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CapabilitiesTest extends SimpleTest {
    private Map<String, Object> capabilitiesMap = new HashMap<>();

    @Parameters({"javascriptEnabled"})
    @BeforeSuite
    public void init(@Optional("true") boolean javascriptEnabled) {
        capabilitiesMap.put("javascriptEnabled", javascriptEnabled);
    }

    @Test
    public void chromeOptionsTest() throws InterruptedException {
        List<String> options = new ArrayList<>();
        //options.add("--headless");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", capabilitiesMap);
        chromeOptions.addArguments(options);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\horny\\Desktop\\automation\\automationtraining\\src\\main\\resources\\files\\chromedriver_78.exe");

        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://sazka.cz");

        WebElement element = driver.findElement(By.xpath("//*[@id='sportka-banner']"));
        element.click();

        Thread.sleep(6000);
        driver.close();
        driver.quit();
        //RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
    }

    @Test
    public void firefoxOptionsTest() {
        File file = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(file.getPath());
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        options.setProfile(firefoxProfile);
        //System.setProperty("webdriver.firefox.bin", file.getPath());
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\horny\\Desktop\\automation\\automationtraining\\src\\main\\resources\\files\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver(options);
    }

    @Test
    public void ieOptionsTest() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        InternetExplorerDriver driver = new InternetExplorerDriver(options);
    }
}
