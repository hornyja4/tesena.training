package tesena.automation.training.tests.example_4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SimpleTest extends ParentTest{

    @DataProvider
    public Object [][] dataProvider(){
        return new Object[][]{
                {"Subject1", "description1"},
                {"Subject2", "description2"},
                {"Subject3", "description3"},
                {"Subject4", "description4"}
        };
    }

    @Test(dataProvider = "dataProvider", testName = "test")
    public void test(String subject, String description) {

        remoteWebDriver
                .findElement(By.xpath("//a[@href='/projects']"))
                .click();

        //waiting for parent of projects
        waitForElement(By.id("projects-index"), 10);

        remoteWebDriver                                                       //(text(), 'Anna')
                .findElement(By.xpath("//div[@id='projects-index']//a[contains(@href, 'matt')]"))
                .click();

        waitForElement(By.xpath("//a[contains(@href, 'issues/new')]"), 10);

        //click to new issue
        remoteWebDriver
                .findElement(By.xpath("//a[contains(@href, 'issues/new')]"))
                .click();

        waitForElement(By.id("issue-form"), 10);

        WebElement form = remoteWebDriver.findElement(By.id("issue-form"));
        form.findElement(By.xpath(".//input[@id='issue_subject']")).sendKeys(subject);
        form.findElement(By.xpath(".//textarea[@id='issue_description']")).sendKeys(description);
        form.findElement(By.xpath(".//input[@type='submit']")).click();
    }
}
