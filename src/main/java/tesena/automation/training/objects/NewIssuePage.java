package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class NewIssuePage extends ProjectDetailPage {

    /*@HasXpath(xpath = "//form[@id='newIssue']")
    private IssueForm issueForm;*/

    @FindBy(xpath = "//input[@id='issue_subject']")
    private WebElement subject;

    @FindBy(xpath = "//textarea[@id='issue_description']")
    private WebElement description;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public NewIssuePage(DriverManager driverManager) {
        super(driverManager);
    }

    public IssuePage fillIssueForm(String subject, String description) {
        this.subject.sendKeys(subject);
        this.description.sendKeys(description);
        this.submit.click();
        return new IssuePage(driverManager);
    }
}
