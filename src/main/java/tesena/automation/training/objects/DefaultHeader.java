package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class DefaultHeader extends PageObject {

    @FindBy(xpath = "//a[@href='/projects']")
    private WebElement projects;

    @FindBy(xpath = "//a[@href='/']")
    protected WebElement home;

    public DefaultHeader(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        waitForElement(projects);
    }
}
