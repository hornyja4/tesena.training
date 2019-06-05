package tesena.automation.training.tests.example_4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

public class ActionsTest extends SimpleTest {

    @Test
    public void actions() {
        ChromeDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
    }
}
