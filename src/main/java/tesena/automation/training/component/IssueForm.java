package tesena.automation.training.component;

import tesena.automation.training.annotation.HasXpath;
import tesena.automation.training.driver.DriverManager;

public class IssueForm extends Component {

    @HasXpath(xpath = "//input[@id='desc']")
    private Input desc;

    @HasXpath(xpath = "")
    private Input name;

    public IssueForm(DriverManager driverManager) {
        super(driverManager);
    }

    public void fillForm(String name, String desc) {
        this.desc.sendKeys(desc);
        this.name.sendKeys(name);
    }
}
