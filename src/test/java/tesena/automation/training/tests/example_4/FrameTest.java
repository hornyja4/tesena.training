package tesena.automation.training.tests.example_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.concurrent.TimeUnit;

public class FrameTest extends SimpleTest {
    private WebDriver driver;

    @Test
    public void frame() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///C:\\Users\\horny\\Desktop\\automation\\automationtraining\\src\\main\\resources\\htmlPage.html");
        WebElement frame = driver.findElement(By.xpath("//iframe[@data-test='frame_1']"));
        driver.switchTo().frame(frame);
        WebElement frameElement = driver.findElement(By.xpath("//*[@data-test='frame-text']"));
        System.out.println(frameElement.getText());
    }

    @AfterTest
    public void reset() {
        driver.quit();
    }
}
