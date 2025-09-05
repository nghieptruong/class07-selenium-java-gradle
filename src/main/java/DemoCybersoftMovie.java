import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoCybersoftMovie {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
        driver.manage().window().maximize();

        //go vao Tai Khoan textbox
//        By byTxtAccount = By.id("taiKhoan");
        By byTxtAccount = By.name("taiKhoan");
        WebElement txtAccount = driver.findElement(byTxtAccount);
        txtAccount.sendKeys("Hello");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
