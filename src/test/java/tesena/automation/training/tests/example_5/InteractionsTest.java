package tesena.automation.training.tests.example_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

public class InteractionsTest extends SimpleTest {
    private WebDriver driver;

    @Test
    public void interactions() {
        driver = new ChromeDriver();
        driver.get("file:///...");
    }

    private void selectCurrency(String currency) {
    }

}
