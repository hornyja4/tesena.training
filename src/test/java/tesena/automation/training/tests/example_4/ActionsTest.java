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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.svethardware.cz/");
        WebElement menuItem = driver.findElement(By.xpath("//a[@href='periferie/']"));
        WebElement mouses = driver.findElement(By.xpath("//a[@href='mysi/']"));
        Actions actions = new Actions(driver);
        Action moveAction = actions
                .moveToElement(menuItem)
                .pause(1000)
                .click(mouses)
                .build();

        moveAction.perform();
        Thread.sleep(10000);
    }
}
