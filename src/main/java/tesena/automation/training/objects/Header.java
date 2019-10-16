package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class Header extends DefaultHeader {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    public Header(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        waitForElement(loginButton);
    }

    public LoginPage clickToLogin() {
        logger.info("clickToLogin();");
        loginButton.click();
        return new LoginPage(driverManager);
    }
}
