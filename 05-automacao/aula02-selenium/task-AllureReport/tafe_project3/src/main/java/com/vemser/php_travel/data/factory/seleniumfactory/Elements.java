package com.vemser.php_travel.data.factory.seleniumfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends SeleniumFactory {

    public static WebElement elemento(By by){
        return driver.findElement(by);
    }

    public static void esperarElemento(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void hoverElemento(By by){
        Actions builder = new Actions(driver);

        WebElement element = driver.findElement(by);
        builder.moveToElement(element).perform();
    }
}
