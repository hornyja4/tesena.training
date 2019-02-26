package tesena.automation.training.tests.example_2;

import org.testng.annotations.Test;

public class ExpectedExceptions {

    @Test(expectedExceptions = FieldException.class)
    public void testException() {
        System.out.println("testException");
        throw new InputException("Exception at testException");
    }
}
