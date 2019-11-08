package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

import javax.swing.*;

public class SportkaHomePage extends HeaderMenu {

    @FindBy(id = "online-bet")
    private WebElement betOnline;

    public SportkaHomePage(DriverManager driverManager) {
        super(driverManager);
    }

    public SportkaBettingPage betOnline() {
        waitForElement(betOnline).click();
        return new SportkaBettingPage(driverManager);
    }
}
