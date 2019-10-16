package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class LoggedHeader extends DefaultHeader {

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logout;

    public LoggedHeader(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        super.synchronize();
        waitForElement(logout);
    }

    public DefaultPage logout() {
        logout.click();
        return new DefaultPage(driverManager);
    }
}
