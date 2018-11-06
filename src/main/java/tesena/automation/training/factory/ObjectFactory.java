package tesena.automation.training.factory;

import tesena.automation.training.component.Component;
import tesena.automation.training.driver.DriverManager;
import tesena.automation.training.driver.PageObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class ObjectFactory {

    public static void processComponents(PageObject pageObject, DriverManager driverManager) {
        Class<? extends PageObject> klass = pageObject.getClass();
        createComponent(klass, pageObject, driverManager);
        while (!(klass = (Class<? extends PageObject>) klass.getSuperclass()).equals(PageObject.class)) {
            createComponent(klass, pageObject, driverManager);
        }
    }

    private static void createComponent(Class klass, PageObject object, DriverManager driverManager) {
        for (Field field: klass.getDeclaredFields()) {
            System.out.println(field.getName() + ":" + isComponent(field));
            if (isComponent(field)) {
                Component component = null;
                try {
                    component = field.getType().asSubclass(Component.class).getConstructor(DriverManager.class).newInstance(driverManager);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                field.setAccessible(true);
                try {
                    field.set(object, component);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isComponent(Field field) {
        Class fieldType = field.getType();
        while ((fieldType = fieldType.getSuperclass()) != Component.class) {
            if (fieldType == null) {
                return false;
            }
        }
        return true;
    }

}
