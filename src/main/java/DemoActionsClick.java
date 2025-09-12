import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoActionsClick {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("C:\\Data\\Training\\Automation_Testing\\class07\\class07-selenium-java-gradle\\src\\main\\java\\webbasic\\actionsdemo\\actions-click-demo.html");

        By byBtnNormalClick = By.id("normalClick");
        WebElement btnNormalClick = wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnNormalClick));

        Actions actions = new Actions(driver);
        actions.click(btnNormalClick).perform();

        Thread.sleep(3000);

        driver.quit();
    }
}
