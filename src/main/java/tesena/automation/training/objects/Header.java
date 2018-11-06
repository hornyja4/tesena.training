package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class Header extends PageObject {

    @FindBy(xpath = "//div[@id='loggedas']")
    private WebElement loggedas;

    @FindBy(xpath = "//a[@href='/projects']")
    private WebElement projects;

    public Header(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        waitForElement(loggedas);
    }

    public ProjectsPage projects() {
        projects.click();
        return new ProjectsPage(driverManager);
    }
}
