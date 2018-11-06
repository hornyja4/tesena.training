package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class DefaultPage extends PageObject {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login;

    public DefaultPage(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        waitForElement(login);
    }

    public void clickToLogin() {
        login.click();
    }
}
