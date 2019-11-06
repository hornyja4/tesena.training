package tesena.automation.training.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private RemoteWebDriver driver;
    private TestProperties properties;

    public DriverManager(TestProperties testProperties) {
        this.properties = testProperties;
        getDriver();
    }

    public RemoteWebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        initDrivers();
        if (properties.isRemote()) {
            try {
                URL url = new URL(properties.getRemoteUrl());
                driver = new RemoteWebDriver(url, properties.getCapabilities());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            Platform platform = properties.getPlatform();
            switch (platform) {
                case WINDOWS:
                    String browserName = properties.getBrowserName();
                    switch (browserName) {
                        case "CHROME":
                            driver = new ChromeDriver();
                            break;
                        case "FIREFOX":
                            driver = new FirefoxDriver();
                            break;
                        case "IE":
                            driver = new InternetExplorerDriver();
                            break;
                    }
                    break;
                case ANDROID:
                    break;
                default:
                    throw new RuntimeException("You set wrong platform. Options are WINDOWS or ANDROID");
            }
        }
        driver.get(properties.getWebUrl());
        driver.manage().window().maximize();
        return driver;
    }

    private void initDrivers() {
        System.setProperty("webdriver.chrome.driver", "");
        System.setProperty("webdriver.gecko.driver", "");

    }

    void waitForElement(WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                return element.isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        try {
            wait.until(input -> expectation.apply(driver));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout exception: Element is not visible after " + 10 + " seconds.", e);
        }
    }

    void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        };
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(input -> expectation.apply(driver));
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
