package tesena.automation.training.tests.example_3;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test(parameters = {"browser", "version", "env"})
    public void parameterTest(@Optional("chrome") String browser, @Optional("65") int version, @Optional("UAT") String env) {
        System.out.println(browser + ", " + version + ", " + env);
    }
}
