import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckboxDemo {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://dummypoint.com/seleniumtemplate.html");

        By byChkCheckbox1 = By.xpath("//input[@value='c1']");
//        setCheckbox(driver, byChkCheckbox1, true); // muon chon checkbox
        setCheckbox(driver, byChkCheckbox1, false); // bo chon checkbox

        Thread.sleep(3000);

        driver.quit();

    }
    // flag = true --> muon chon
    // flag = false --> ko muon chon
    public static void setCheckbox(WebDriver driver, By byLocator, boolean flag) {
        WebElement chkCheckbox = driver.findElement(byLocator);
        if(chkCheckbox.isSelected() != flag) {
            chkCheckbox.click();
        }
    }
}
