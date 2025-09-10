import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TableDemo {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true);
//        options.setBrowserVersion("137"); // chay voi browser chrome version 137

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://dummypoint.com/Tables.html");

        String tbSimpleTableString = "//table";

        String value = getValueByIndex(driver, tbSimpleTableString, 1, 1);
        System.out.println(value);

        Thread.sleep(3000);

        driver.quit();
    }
    public static String getValueByIndex(WebDriver driver, String strLocator, int row, int col) {
        String cellTemplate = strLocator + "/tbody//tr[%d]/td[%d]"; // --> //table/tbody//tr[%d]/td[%d]
        String cellLocator = String.format(cellTemplate, row, col); // --> //table/tbody//tr[1]/td[2]
        By byCell = By.xpath(cellLocator); // --> co kieu By
        WebElement cellElement = driver.findElement(byCell);
        String value = cellElement.getText();
        return value;
    }
    public static String getValueByColumnName(WebDriver driver, String strLocator, String columnName) {

        return "";
    }
    public static String getValueByColumnIndex(WebDriver driver, String strLocator, int columnIndex) {

        return "";
    }
    public static String getColumnName(WebDriver driver, String strLocator, int index) {
        return "";
    }
    public static List<String> getAllColumnNames(WebDriver driver, String strLocator) {

        return null;
    }
}
