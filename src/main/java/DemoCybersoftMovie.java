import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class DemoCybersoftMovie {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        WebDriver driver = new ChromeDriver(options);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // da hinh trong java
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                        .ignoring(NotFoundException.class)
                                .pollingEvery(Duration.ofMillis(500));

        //Step 1: Go to https://demo1.cybersoft.edu.vn/sign-up
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
        driver.manage().window().maximize();


        //Step 2: Enter value on 'Tai khoan' textbox
        //go vao Tai Khoan textbox
//        By byTxtAccount = By.id("taiKhoan");
        String account = "Test" + UUID.randomUUID();
        String newAcount = account.replace("-", "");
        By byTxtAccount = By.name("taiKhoan");

//        WebElement txtAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccount)); // visibilityOfElementLocated: wait cho element hien thi tren web (nhin thay element)
        WebElement txtAccount = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccount));

        txtAccount.sendKeys(newAcount);

        //Step 3: Enter value on 'Mat Khau' textbox
        By byTxtPassword = By.id("matKhau");

        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        txtPassword.sendKeys("Test123456@");

        //Step 4: Enter value on 'Nhap Lai Mat Khau' textbox
        By byTxtConfirmPassword = By.id("confirmPassWord");

        WebElement txtConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
        txtConfirmPassword.sendKeys("Test123456@");

        //Step 5: Enter value on 'Ho ten' textbox
        By byTxtName = By.id("hoTen");

        WebElement txtName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtName));
        txtName.sendKeys("John Kenny");

        //Step 6: Enter value on 'Email' textbox
        String email = newAcount + "@example.com";
        By byTxtEmail = By.id("email");

        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
        txtEmail.sendKeys(email);

        //Step 7: Click 'Dang Ky" button
        By byBtnRegister = By.xpath("//button[.='Đăng ký']");

        WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(byBtnRegister));
        btnRegister.click();

        Thread.sleep(3000); // muc dich hoc , de chuong trinh dung 3s de minh coi ketqua

        driver.quit();
    }
}
