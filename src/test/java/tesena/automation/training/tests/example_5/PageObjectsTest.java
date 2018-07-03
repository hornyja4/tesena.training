package tesena.automation.training.tests.example_5;

import org.testng.annotations.Test;
import tesena.automation.training.data.User;
import tesena.automation.training.data.Users;
import tesena.automation.training.factory.DataFactory;
import tesena.automation.training.factory.POFactory;
import tesena.automation.training.objects.DefaultPage;
import tesena.automation.training.test.RedmineTest;

public class PageObjectsTest extends RedmineTest {
    private User user = DataFactory.createUser(Users.NOVAK);

    @Test
    public void loginTest() {
        DefaultPage defaultPage = POFactory.createObject();
        defaultPage
                .clickToLogin()
                .login(user.getLoginNumber(), user.getPassword())
                .clickToProjects()
                .projectDetail("Biom")
                .newIssue()
                .createIssue(user.getAccount("account_1").getAccountName(), user.getAccount("account_1").getAccountNumber(), "Urgent");
    }
}
