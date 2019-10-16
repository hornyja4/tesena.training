package tesena.automation.training.tests.example_3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicFunctionsTest extends SimpleTest {

    @Test
    public void basicFunctions() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.redmine.org");
        List<WebElement> anchors = driver.findElements(By.xpath("//a"));
        for(WebElement element: anchors) {
            System.out.println(element.getText());
        }
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", login);
        //login.click();
        driver.findElement(By.id("username")).sendKeys("loginName");
        driver.findElement(By.id("password")).sendKeys("password");
        Thread.sleep(5000);
    }
}
