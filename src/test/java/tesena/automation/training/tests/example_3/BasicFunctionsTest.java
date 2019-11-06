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
    }
}
