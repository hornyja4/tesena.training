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
    }
}
