package testngDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_RegisterTest extends BaseTest {

    @Test(description = "test valid register")
    public void testValidRegister() {
        System.out.println("testValidRegister executed");
        Assert.assertTrue(true, "Register successfully");
    }

    @Test(description = "test invalid register")
    public void testInvalidRegister() {
        System.out.println("testInvalidRegister executed");
        Assert.assertTrue(true, "Register failed");
    }
}
