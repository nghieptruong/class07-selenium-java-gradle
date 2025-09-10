import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DemoImplicitWait {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // set thoi gian cho findElement va findElements tim kiem trong 10s neu ko thay

        driver.get("http://dummypoint.com/seleniumtemplate.html");

        ZonedDateTime start = null;
        try {
            By byChkCheckbox1 = By.xpath("//input[@value='c123456']");
            start = ZonedDateTime.now();
            WebElement chkCheckbox1 = driver.findElement(byChkCheckbox1); // tim ko thay --> throw NoSuchElementException
            System.out.println(chkCheckbox1.isSelected()); // tra ve trang thai true or false
        } catch (Exception e) {
            ZonedDateTime end = ZonedDateTime.now();
            long duration = ChronoUnit.SECONDS.between(start, end);
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println("duration = " + duration); // mac dinh la ko doi (=0)
        } finally {
            driver.quit();
        }
    }
}
