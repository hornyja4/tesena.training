package tesena.automation.training.factory;

import org.openqa.selenium.support.PageFactory;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

import java.lang.reflect.Field;

public class POFactory {
    private static DriverManager driverManager;

    public static void processPageObjectComponents(PageObject pageObject) {
        for (Field field: pageObject.getClass().getDeclaredFields()) {
            if (isPageObject(field)) {
                PageObject object = null;
                try {
                    object = field.getType().asSubclass(PageObject.class).newInstance();
                    PageFactory.initElements(driverManager.getDriver(), object);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                field.setAccessible(true);
                try {
                    field.set(pageObject, object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isPageObject(Field field) {
        Class fieldType = field.getType();
        while ((fieldType = fieldType.getSuperclass()) != PageObject.class) {
            if (fieldType == null) {
                return false;
            }
        }
        return true;
    }

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
