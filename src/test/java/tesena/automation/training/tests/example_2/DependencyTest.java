package tesena.automation.training.tests.example_2;

import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void login() {
        System.out.println("login");
        //throw new RuntimeException("Exception in login.");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        System.out.println("logout");
    }

}
