package automationexercise.data.factory.seleniumfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFactory {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void initBrowser(String url) {
        String caminhoDriver = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void tearDown() {
        driver.close();
    }
}
