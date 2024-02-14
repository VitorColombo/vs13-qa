package automationexercise.page;

import automationexercise.data.factory.seleniumfactory.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class BasePage extends Elements {
    protected static void preencherInput(By by, String text){
        esperarElemento(by);
        element(by).sendKeys(text);
    }

    protected static void clicar(By by){
        esperarElemento(by);
        element(by).click();
    }

    protected static String lerTexto(By by){
        esperarElemento(by);
        return element(by).getText();
    }

    protected static void tab(By by){
        esperarElemento(by);
        element(by).sendKeys(Keys.TAB);
    }
}
