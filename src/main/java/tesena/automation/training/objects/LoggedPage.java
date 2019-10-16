package tesena.automation.training.objects;

import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class LoggedPage extends LoggedHeader {

    public LoggedPage(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        super.synchronize();
    }
}
