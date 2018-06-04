package tesena.automation.training.tests.example_4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SimpleTest {
    private RemoteWebDriver remoteWebDriver;

    @Test
    public void test() {
        remoteWebDriver = new ChromeDriver();
        remoteWebDriver.get("http://demo.redmine.org");
        waitForElement(By.xpath("//a[@href='/login']"), 10);
        remoteWebDriver.quit();
    }

    private void waitForElement(By by, int timeout) {
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
