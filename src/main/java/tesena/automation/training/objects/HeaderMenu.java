package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class HeaderMenu extends PageObject {

    @FindBy(xpath = "//span[text()='Menu']")
    private WebElement menu;

    @FindBy(id = "neo-login")
    private WebElement login;

    public HeaderMenu(DriverManager driverManager) {
        super(driverManager);
    }

    public LoginPage login() {
        login.click();
        return new LoginPage(driverManager);
    }
}
