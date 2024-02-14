package automationexercise.data.factory.seleniumfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends SeleniumFactory{

    public static WebElement element(By by){
        return driver.findElement(by);
    }
    public static void esperarElemento(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
