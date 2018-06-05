package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailOverviewPage extends ProjectDetailPage {

    @FindBy(xpath = "//div[@class='issues box']")
    private WebElement issuesBox;

    @Override
    public void synchronize() {
        waitForElement(issuesBox);
    }
}
