package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import tesena.automation.training.factory.POFactory;

public class NewIssuePage extends ProjectDetailPage {
    private WebElement issue_subject;
    private WebElement issue_description;
    private Select select;
    private WebElement issue_priority_id;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    @Override
    public void synchronize() {
        waitForElement(issue_subject);
    }

    public IssueDetailPage createIssue(String subject, String description, String priority) {
        issue_subject.sendKeys(subject);
        issue_description.sendKeys(description);
        select = new Select(issue_priority_id);
        select.selectByVisibleText(priority);
        submit.click();
        return POFactory.createObject();
    }
}
