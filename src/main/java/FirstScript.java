import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver(); // khoi tao doi tuong driver
//        WebDriver driver = new ChromeDriver(); // khoi tao doi tuong driver (đa hình trong OOP trong java)
        driver.get("https://demo1.cybersoft.edu.vn/"); //open trang web

//        FirefoxDriver driver = new FirefoxDriver();
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://demo1.cybersoft.edu.vn/"); //open trang web

//        System.setProperty("webdriver.edge.driver", "C:\\Data\\Training\\Automation_Testing\\msedgedriver.exe");
//        EdgeDriver driver = new EdgeDriver();
//        WebDriver driver = new EdgeDriver();
//        driver.get("https://demo1.cybersoft.edu.vn/"); //open trang web

//        SafariDriver driver = new SafariDriver();
//        WebDriver driver = new SafariDriver();
//        driver.get("https://demo1.cybersoft.edu.vn/"); //open trang web

        Thread.sleep(3000); // chuong trinh tam dung 3giay
        driver.quit(); // quit driver session (kill chromedriver.exe, geckodriver.exe)


    }
}
