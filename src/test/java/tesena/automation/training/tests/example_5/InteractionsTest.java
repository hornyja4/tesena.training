package tesena.automation.training.tests.example_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InteractionsTest extends SimpleTest {

    @Test
    public void interactions() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///C:\\Users\\horny\\Desktop\\automation\\automationtraining\\src\\main\\resources\\htmlPage.html");
        List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@data-test,'transaction')]"));
        for (WebElement row: rows) {
            String date = row.findElement(By.xpath(".//td[@data-test='date']")).getText();
            String description = row.findElement(By.xpath(".//td[@data-test='description']")).getText();
            String amount = row.findElement(By.xpath(".//td[@data-test='amount']")).getText();
            String currency = row.findElement(By.xpath(".//td[@data-test='currency']")).getText();
            System.out.println(date + ", " + description + ", " + amount + ", " + currency);
        }
        selectCurrency("EUR");
        Thread.sleep(10000);
    }

    private void selectCurrency(String currency) {
        WebElement select = driver.findElement(By.xpath("//select"));
        select.click();
        select.findElement(By.xpath(".//option[text()='" + currency + "']")).click();
        select.click();
    }
}
