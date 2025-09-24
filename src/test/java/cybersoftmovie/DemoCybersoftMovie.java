package cybersoftmovie;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;

public class DemoCybersoftMovie {

    WebDriver driver;
    Wait<WebDriver> wait;
    Wait<WebDriver> fluentWait;

    //khoi tao driver
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class executed");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method executed");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // da hinh trong java
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(NotFoundException.class)
                .pollingEvery(Duration.ofMillis(500));
        driver.manage().window().maximize();
    }

    //priority số nhỏ sẽ chạy trước priority số lớn
    @Test(priority = 0)
    public void testRegister() {
        System.out.println(driver + " - testRegister running...");

        //Step 1: Go to https://demo1.cybersoft.edu.vn/sign-up
        Reporter.log("Step 1: Go to https://demo1.cybersoft.edu.vn/sign-up");
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");

        //Step 2: Enter value on 'Tai khoan' textbox
        Reporter.log("Step 2: Enter value on 'Tai khoan' textbox");
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

        //Step 8: Verify register successfully
        //VP: "Đăng ký thành công" message displays
        By byLblRegisterMsg = By.id("swal2-title");
        WebElement lblRegisterMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblRegisterMsg));
        String actualMsg = lblRegisterMsg.getText();
        Assert.assertEquals(actualMsg, "Đăng ký thành công", "Register message");

        //VP: Verify new account login successfully
        driver.get("https://demo1.cybersoft.edu.vn");
        By byLnkLogin = By.xpath("//h3[text()='Đăng Nhập']");
        By byTxtAccountLogin = By.id("taiKhoan");
        By byTxtPasswordLogin = By.id("matKhau");
        By byBtnLogin = By.xpath("//button[.='Đăng nhập']");

        WebElement lnkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogin));
        lnkLogin.click(); // navigate wa trang login

        WebElement txtAccountLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtAccountLogin));
        txtAccountLogin.sendKeys(newAcount);

        WebElement txtPasswordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
        txtPasswordLogin.sendKeys("Test123456@");

        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        btnLogin.click();

        //VP1: "Đăng nhập thành công" message displays
        By byLblLoginMsg = By.id("swal2-title");
        WebElement lblLoginMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginMsg));
        String actualLoginMsg = lblLoginMsg.getText();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login message");

        //VP2: User profile name displays
        By byLblUserProfile = By.xpath("//a[@href='/account']/h3");
        WebElement lblUserProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblUserProfile));
        String actualDisplayName = lblUserProfile.getText();
        Assert.assertEquals(actualDisplayName, "John Kenny", "User Profile name");


    }

    @Test(priority = 1)
    public void testInvalidRegister() {
        System.out.println(driver + " - testInvalidRegister running...");

        //Step 1: Go to https://demo1.cybersoft.edu.vn/sign-up
        driver.get("https://demo1.cybersoft.edu.vn/sign-up");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method executed");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class executed");
        driver.quit();
    }
}
