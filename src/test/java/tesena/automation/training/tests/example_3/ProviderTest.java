package tesena.automation.training.tests.example_3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ProviderTest {

    @Test(dataProvider = "dataMethodProvider")
    public void test_1(String email){
        System.out.println("@Test_1 email:" + email);
    }

    @Test(dataProvider = "dataMethodProvider")
    public void test_2(int number){
        System.out.println("@Test_2 number:" + number);
    }

    @DataProvider
    public Object [][] dataMethodProvider(Method method){
        Object[][] result = null;
        if(method.getName().equals("test_1")){
            result =  new Object[][]{{"hornych.h@gmail.com"}};
        }else if(method.getName().equals("test_2")){
            result =  new Object[][]{{739627731}};
        }
        return result;
    }

    @DataProvider
    public Object [][] dataProvider(){
        return new Object[][]{
                {'A'},
                {'B'},
                {'C'},
                {'D'}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void test(char character){
        System.out.println(character);
    }
}
