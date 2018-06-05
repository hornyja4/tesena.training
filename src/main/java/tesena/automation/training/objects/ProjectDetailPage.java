package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.factory.POFactory;

public class ProjectDetailPage extends Header {

    @FindBy(xpath = "//a[contains(@href, 'issues/new')]")
    private WebElement newIssue;

    @Override
    public void synchronize() {
        waitForElement(newIssue);
    }

    public NewIssuePage newIssue() {
        newIssue.click();
        return POFactory.createObject();
    }
}
