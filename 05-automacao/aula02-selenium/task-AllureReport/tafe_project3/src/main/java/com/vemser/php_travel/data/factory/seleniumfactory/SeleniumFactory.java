package com.vemser.php_travel.data.factory.seleniumfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void abrirNavegador(String url){

        String os = System.getProperty("os.name").toLowerCase();
        String caminhoDriver = os.contains("win") ? "driver/chromedriver.exe" : "driver/chromedriver";

        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get(url);
        driver.manage().window().maximize();
    }

    public void fecharNavegador(){
        driver.close();
    }
}
