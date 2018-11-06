package tesena.automation.training.component;

import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class Button<T extends PageObject> extends Component {

    String email = "hornych.h@gmail.com";

    public Button(DriverManager driverManager) {
        super(driverManager);
    }

    /*
    public T clickButton() {

    } */
}
