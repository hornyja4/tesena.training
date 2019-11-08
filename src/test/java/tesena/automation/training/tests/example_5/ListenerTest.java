package tesena.automation.training.tests.example_5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(NewListener.class)
public class ListenerTest extends SimpleTest {
    static ChromeDriver driver;

    @Test
    public void testWithListener() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://sazka.cz");
        WebElement sportkaBanner = driver.findElement(By.xpath("//a[@href='/loterie/sportka']"));
        File screen = sportkaBanner.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(
                    screen,
                    new File("/screens/banner.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//a[@abc='asd']"));
    }

    @AfterClass
    public void reset() {
        driver.quit();
    }
}
