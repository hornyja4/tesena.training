package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.PageObject;
import tesena.automation.training.factory.POFactory;

public class Header extends PageObject {

    @FindBy(xpath = "//a[@href='/projects']")
    private WebElement projects;

    @Override
    public void synchronize() {
        waitForElement(projects);
    }

    public ProjectsPage clickToProjects() {
        projects.click();
        return POFactory.createObject();
    }
}
