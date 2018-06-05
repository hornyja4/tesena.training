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
    private static DriverManager instance;

    /**
     * Singleton pattern
     *
     * @return DriverManager instance
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private DriverManager() {
        getDriver();
    }

    public RemoteWebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        initDrivers();
        if (PropertiesManager.isRemote()) {
            try {
                URL url = new URL(PropertiesManager.getRemoteUrl());
                driver = new RemoteWebDriver(url, PropertiesManager.getCapabilities());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            Platform platform = PropertiesManager.getPlatform();
            switch (platform) {
                case WINDOWS:
                    String browserName = PropertiesManager.getBrowserName();
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
        driver.get(PropertiesManager.getWebUrl());
        driver.manage().window().maximize();
        return driver;
    }

    private void initDrivers() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

    }

    public void waitForElement(WebElement element) {
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

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(input -> expectation.apply(driver));
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
