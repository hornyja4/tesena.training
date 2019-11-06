package tesena.automation.training.tests.example_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.concurrent.TimeUnit;

public class InteractionsTest extends SimpleTest {

    @Test
    public void interactions() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///");
    }

    private void selectCurrency(String currency) {
    }
}
