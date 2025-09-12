package testNGDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScript {

    @Test
    public void testScript() {
        Assert.assertEquals(1, 2, "Example test");
    }
}
