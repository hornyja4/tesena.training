package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.components.Table;
import tesena.automation.training.driver.PageObject;
import tesena.automation.training.factory.POFactory;

public class LoginPage extends PageObject {
    private WebElement username;
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    @Override
    public void synchronize() {
        waitForElement(submit);
    }

    public HomePage login(String username, String pwd) {
        this.username.sendKeys(username);
        password.sendKeys(pwd);
        submit.click();
        return POFactory.createObject();
    }
}
