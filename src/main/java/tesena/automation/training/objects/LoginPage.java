package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        waitForElement(username);
        waitForElement(password);
        waitForElement(submit);
    }

    public HomePage login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
        return new HomePage(driverManager);
    }
}
