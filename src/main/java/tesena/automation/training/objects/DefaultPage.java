package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.PageObject;
import tesena.automation.training.factory.POFactory;

public class DefaultPage extends PageObject {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login;

    @Override
    public void synchronize() {
        waitForElement(login);
    }

    public LoginPage clickToLogin() {
        login.click();
        return POFactory.createObject();
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
