import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DemoWindowsHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://demoqa.com/browser-windows");

        By byBtnNewTab = By.id("tabButton");
        WebElement btnNewTab = wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnNewTab));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", btnNewTab);

        String mainWindow = driver.getWindowHandle(); // lay id cua main window
        System.out.println(mainWindow);

        //ra new Tab
//        btnNewTab.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnNewTab);

        Set<String> allWindowsId = driver.getWindowHandles();
        System.out.println("-----------------");
        System.out.println(allWindowsId);

        for(String id : allWindowsId) {
            if(!mainWindow.equals(id)) {
                driver.switchTo().window(id); //switch sang tab moi
            }
        }

        //capture element o new tab
        By byLblSample = By.id("sampleHeading");
        WebElement lblSample = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblSample));
        System.out.println("-----------------");
        System.out.println(lblSample.getText());
        driver.close(); //dong cai tab (windows) hien tai

        Thread.sleep(3000);

        //khac nhau giua driver.quit() va driver.close() ?
        driver.quit(); // quit driver session --> close all windows
    }
}
