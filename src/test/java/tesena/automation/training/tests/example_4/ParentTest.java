package tesena.automation.training.tests.example_4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({SimpleListener.class})
public class ParentTest {
    public static RemoteWebDriver remoteWebDriver;

    @BeforeClass
    @Parameters({"name", "password"})
    public void login(@Optional("hornyja4") String name, @Optional("Honza123456") String password) {
        System.setProperty("webdriver.chrome.driver", "C://tools//chromedriver.exe");
        remoteWebDriver = new ChromeDriver();
        remoteWebDriver.manage().window().maximize();
        remoteWebDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        remoteWebDriver.get("http://demo.redmine.org");
        waitForElement(By.xpath("//a[@href='/login']"), 10);

        //click to login anchor
        remoteWebDriver.findElement(By.xpath("//a[@href='/login']")).click();

        //waiting for elements
        waitForElement(By.xpath("//input[@id='username']"), 10);
        waitForElement(By.xpath("//input[@id='password']"), 10);

        remoteWebDriver
                .findElement(By.xpath("//input[@id='username']"))
                .sendKeys(name);
        remoteWebDriver
                .findElement(By.xpath("//input[@id='password']"))
                .sendKeys(password);
        remoteWebDriver
                .findElement(By.xpath("//input[@type='submit']"))
                .click();

        waitForElement(By.id("loggedas"), 10);
    }

    @AfterClass
    public void reset() {
        remoteWebDriver.quit();
    }

    protected void waitForElement(By by, int timeout) {
        waitForPageToLoad();
        Wait<WebDriver> wait = new WebDriverWait(remoteWebDriver, timeout);
        ExpectedCondition<Boolean> expectation = driver -> {
            try {
                return driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        };
        try {
            wait.until(input -> expectation.apply(remoteWebDriver));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout exception: Element is not visible after " + timeout + " seconds.", e);
        }
    }

    private void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        Wait<WebDriver> wait = new WebDriverWait(remoteWebDriver, 10);
        wait.until(input -> expectation.apply(remoteWebDriver));
    }
}
