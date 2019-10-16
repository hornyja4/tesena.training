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
    public static ChromeDriver driver;

    @Test
    public void testWithListener() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.redmine.org");
        WebElement element = driver.findElement(By.xpath("//a[@href='/login']"));
        File screenFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenFile, new File("C:\\Users\\horny\\Desktop\\SmartDriver\\automationtraining\\screens\\element.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @AfterClass
    public void reset() {
        driver.quit();
    }
}
