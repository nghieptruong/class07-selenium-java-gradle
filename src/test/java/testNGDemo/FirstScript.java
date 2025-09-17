package testNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScript {

    @Test
    public void testFirstScript() {
        Assert.assertEquals(1, 1, "Test Example 1");
    }

    @Test
    public void testSecondScript() {
        Assert.assertEquals(1, 1, "Test Example 2");
    }

}
