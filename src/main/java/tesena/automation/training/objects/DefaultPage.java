package tesena.automation.training.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.annotation.HasXpath;
import tesena.automation.training.component.Anchor;
import tesena.automation.training.component.Button;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class DefaultPage extends PageObject {

    /*
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login; */

    @HasXpath(xpath = "//a[@href='/login']")
    private Button<LoginPage> login;

    public DefaultPage(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        //waitForElement(login);
    }

    public LoginPage clickToLogin() {
        System.out.println(login.getXpath());
        login.click();
        return new LoginPage(driverManager);
    }
}
