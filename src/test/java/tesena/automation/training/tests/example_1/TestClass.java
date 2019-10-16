package tesena.automation.training.tests.example_1;

import org.testng.annotations.Test;
import tesena.automation.training.factory.DataFactory;

public class TestClass {

    @Test
    public void test() {
        System.out.println(DataFactory.getBundleProperty("PAYMENT"));
    }

    @Test
    public void test2() {
        System.out.println(DataFactory.getBundleProperty("PAYMENT"));
    }

    @Test
    public void test3() {
        System.out.println(DataFactory.getBundleProperty("PAYMENT"));
    }
}
