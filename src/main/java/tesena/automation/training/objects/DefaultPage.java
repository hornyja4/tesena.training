package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.PageObject;

public class DefaultPage extends PageObject {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement login;

    @Override
    public void synchronize() {
        waitForElement(login);
    }

    public void clickToLogin() {
        login.click();
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
