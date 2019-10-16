package tesena.automation.training.tests.example_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.concurrent.TimeUnit;

public class ActionsTest extends SimpleTest {

    @Test
    public void actions() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://alza.cz");
        WebElement login = driver.findElement(By.xpath("//a[contains(@href, '/be-smart-by-alza')]"));
        Actions actions = new Actions(driver);
        Action action = actions
                .moveToElement(login)
                .build();

        action.perform();
        Thread.sleep(5000);
    }
}
