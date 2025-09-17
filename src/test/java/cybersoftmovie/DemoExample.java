package cybersoftmovie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoExample {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01() {
        System.out.println(driver + "TC_01 executed");
    }

    @Test
    public void TC_02() {
        System.out.println(driver + "TC_02 executed");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
        driver.quit();
    }
}
