package tesena.automation.training.tests.example_4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleTest {
    private RemoteWebDriver remoteWebDriver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C://tools/chromedriver.exe");
        remoteWebDriver = new ChromeDriver();
        remoteWebDriver.manage().window().maximize();
        remoteWebDriver.get("http://demo.redmine.org");
        waitForElement(By.xpath("//a[@href='/login']"), 10);

        //click to login anchor
        remoteWebDriver.findElement(By.xpath("//a[@href='/login']")).click();

        //waiting for elements
        waitForElement(By.xpath("//input[@id='username']"), 10);
        waitForElement(By.xpath("//input[@id='password']"), 10);

        remoteWebDriver
                .findElement(By.xpath("//input[@id='username']"))
                .sendKeys("hornyja4");
        remoteWebDriver
                .findElement(By.xpath("//input[@id='password']"))
                .sendKeys("Honza123456");
        remoteWebDriver
                .findElement(By.xpath("//input[@type='submit']"))
                .click();

        waitForElement(By.id("loggedas"), 10);

        remoteWebDriver
                .findElement(By.xpath("//a[@href='/projects']"))
                .click();

        //waiting for parent of projects
        waitForElement(By.id("projects-index"), 10);

        remoteWebDriver                                                       //(text(), 'Anna')
                .findElement(By.xpath("//div[@id='projects-index']//a[contains(@href, 'anna')]"))
                .click();

        waitForElement(By.xpath("//a[contains(@href, 'issues/new')]"), 10);

        //click to new issue
        remoteWebDriver
                .findElement(By.xpath("//a[contains(@href, 'issues/new')]"))
                .click();

        waitForElement(By.id("issue-form"), 10);

        WebElement form = remoteWebDriver.findElement(By.id("issue-form"));
        form.findElement(By.xpath(".//input[@id='issue_subject']")).sendKeys("Subject_honza");
        form.findElement(By.xpath(".//textarea[@id='issue_description']")).sendKeys("Desc...");
        form.findElement(By.xpath(".//input[@type='submit']")).click();

        //remoteWebDriver.quit();
    }

    private void waitForElement(By by, int timeout) {
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
