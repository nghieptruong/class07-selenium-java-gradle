package testngDemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_LoginTest extends BaseTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        //doc tu file json, xml, csv, excel (bad)
        return new Object[][]{
                {"ValidUser","InvalidPass", "Invalid Credentials!"},
                {"ValidUser","", "Invalid User or Password!"}
        };
    }

    @Test(description = "test valid login")
    public void testValidLogin() {
        System.out.println("testValidLogin executed");
//        Hard Assert Demo
//        Assert.assertTrue(false, "test failed assert"); // failed
//        Assert.assertTrue(true, "Login successfully"); // ??? kiem tra ????

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false, "test failed 1 assert");
        softAssert.assertTrue(true, "Login successfully");
        softAssert.assertTrue(false, "test failed 2 assert");
        softAssert.assertAll();
    }

    @Test(description = "test invalid login", dataProvider = "invalidLoginData")
    public void testInValidLogin(String user, String password, String errorMsg) {
        System.out.println("testInValidLogin executed: " + user + " with " + password);
        Assert.assertEquals(errorMsg, "Invalid User or Password!","Login failed"); // hard Assert 1
    }
}
