package tesena.automation.training.tests.example_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.concurrent.TimeUnit;

public class FrameTest extends SimpleTest {
    private WebDriver driver;

    @Test
    public void frame() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///C:\\Users\\horny\\Desktop\\SmartDriver\\automationtraining\\src\\main\\resources\\htmlPage.html");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@data-test='frame_1']")));
        driver.findElement(By.id("frameBox_1"));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame_2']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@data-test='frame_3']")));
        System.out.println(driver.findElement(By.xpath("//span[@data-test='frame-text']")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.xpath("//span[@data-test='frame-text']")).getText());
        Thread.sleep(5000);

    }

    @AfterTest
    public void reset() {
        driver.quit();
    }

}
