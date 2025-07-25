package Aula01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador() {
        String caminhoDriver = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void deveFazerLoginComSucesso() {

        String btnLogin = "#form div div div.col-sm-4.col-sm-offset-1 div form > button";
        String btnLogout = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";
        String email = "input[data-qa=\"login-email\"]";
        String password = "input[data-qa=\"login-password\"]";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(email)));
        driver.findElement(By.cssSelector(email)).sendKeys("vs@gmail.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(password)));
        driver.findElement(By.cssSelector(password)).sendKeys("123456");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnLogin)));
        driver.findElement((By.cssSelector(btnLogin))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnLogout)));
        String textBtnLogout = driver.findElement(By.cssSelector(btnLogout)).getText();
        Assert.assertEquals(textBtnLogout, "Logout");
    }

    @AfterTest
    public void fecharNavegador() {
        driver.quit();
    }
}
