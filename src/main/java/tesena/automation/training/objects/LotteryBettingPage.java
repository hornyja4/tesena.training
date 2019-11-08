package tesena.automation.training.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class LotteryBettingPage extends PageObject {

    @FindBy(id = "dialog-column-checkboxes")
    private WebElement numbers;

    @FindBy(id = "dialog-column-save")
    protected WebElement saveButton;

    @FindBy(id = "dialog-column-save-and-next")
    private WebElement saveAndNext;

    public LotteryBettingPage(DriverManager driverManager) {
        super(driverManager);
    }

    protected void selectGameNumbers(String[] numbers) {
        waitForElement(this.numbers);
        for (String number: numbers) {
            this.numbers.findElement(By.xpath(".//span[text()='" + number +"']")).click();
        }
    }
}
