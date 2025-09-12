import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("C:\\Data\\Training\\Automation_Testing\\class07\\class07-selenium-java-gradle\\src\\main\\java\\webbasic\\InvisibilityOfElementLocated\\InvisibilityOfElementLocatedDemo.html");

        By byBtnStart = By.id("start");
        WebElement btnStart = driver.findElement(byBtnStart);
        btnStart.click();

        By byLblTarget = By.id("target");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLblTarget));

        //kiem tra coi lb target bien mat ?

        WebElement lblTarget = driver.findElement(byLblTarget);
        System.out.println(lblTarget.isDisplayed()); // ==> false

        Thread.sleep(3000);

        driver.quit();
    }
}
