package tesena.automation.training.factory;

import org.openqa.selenium.support.PageFactory;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

public class POFactory {
    private static DriverManager driverManager;

    @SuppressWarnings("unchecked")
    public static <T extends PageObject> T createObject(T... klazz){
        driverManager = DriverManager.getInstance();
        Object object = null;
        try {
            object = klazz.getClass().getComponentType().newInstance();
            PageFactory.initElements(driverManager.getDriver(), object);
            driverManager.waitForPageToLoad();
            ((PageObject) object).synchronize();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) object;
    }
}
