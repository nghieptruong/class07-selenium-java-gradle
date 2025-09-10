import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

public class DemoCybersoftMovie {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        ChromeDriver driver = new ChromeDriver(options);

        //Step 1: Go to https://demo1.cybersoft.edu.vn/sign-up
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        //Step 2: Enter value on 'Tai khoan' textbox
        //go vao Tai Khoan textbox
//        By byTxtAccount = By.id("taiKhoan");
        String account = "Test" + UUID.randomUUID();
        String newAcount = account.replace("-", "");
        By byTxtAccount = By.name("taiKhoan");
        WebElement txtAccount = driver.findElement(byTxtAccount); //NoSuchElementException
        txtAccount.sendKeys(newAcount);

        Thread.sleep(2000);

        //Step 3: Enter value on 'Mat Khau' textbox
        By byTxtPassword = By.id("matKhau");
        WebElement txtPassword = driver.findElement(byTxtPassword);
        txtPassword.sendKeys("Test123456@");

        Thread.sleep(2000);

        //Step 4: Enter value on 'Nhap Lai Mat Khau' textbox
        By byTxtConfirmPassword = By.id("confirmPassWord");
        WebElement txtConfirmPassword = driver.findElement(byTxtConfirmPassword);
        txtConfirmPassword.sendKeys("Test123456@");

        Thread.sleep(2000);

        //Step 5: Enter value on 'Ho ten' textbox
        By byTxtName = By.id("hoTen");
        WebElement txtName = driver.findElement(byTxtName);
        txtName.sendKeys("John Kenny");

        Thread.sleep(2000);

        //Step 6: Enter value on 'Email' textbox
        String email = newAcount + "@example.com";
        By byTxtEmail = By.id("email");
        WebElement txtEmail = driver.findElement(byTxtEmail);
        txtEmail.sendKeys(email);

        Thread.sleep(2000);

        //Step 7: Click 'Dang Ky" button
        By byBtnRegister = By.xpath("//button[.='Đăng ký']");
        WebElement btnRegister = driver.findElement(byBtnRegister);
        btnRegister.click();

        Thread.sleep(3000);

        driver.quit();
    }
}
