package tesena.automation.training.tests.example_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tesena.automation.training.test.SimpleTest;

import java.util.concurrent.TimeUnit;

public class InteractionsTest extends SimpleTest {

    @Test
    public void interactions() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///C:\\Users\\horny\\Desktop\\SmartDriver\\automationtraining\\src\\main\\resources\\htmlPage.html");
        WebElement table = driver.findElement(By.xpath("//table"));
        for (WebElement row: table.findElements(By.xpath(".//tr[contains(@data-test, 'transaction')]"))) {
            WebElement date = row.findElement(By.xpath(".//td[@data-test='date']"));
            WebElement description = row.findElement(By.xpath(".//td[@data-test='description']"));
            WebElement amount = row.findElement(By.xpath(".//td[@data-test='amount']"));
            WebElement currency = row.findElement(By.xpath(".//td[@data-test='currency']"));
            System.out.println(date.getText() + ", " + description.getText() + ", " + amount.getText() + ", " + currency.getText());
        }
        selectCurrency("EUR");
        Thread.sleep(10000);
    }

    private void selectCurrency(String currency) {
        WebElement selectElement = driver.findElement(By.xpath("//select[@data-test='currencySelect']"));
        selectElement.click();
        selectElement.findElement(By.xpath(".//option[text()='" + currency + "']")).click();
        selectElement.click();
    }
}
