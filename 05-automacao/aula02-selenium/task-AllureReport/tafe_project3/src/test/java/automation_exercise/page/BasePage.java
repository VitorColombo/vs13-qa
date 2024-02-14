package automation_exercise.page;

import com.vemser.php_travel.data.factory.seleniumfactory.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends Elements {

    static void preencherInput(By by, String text){
        esperarElemento(by);
        WebElement element = elemento(by);

        element.clear();
        element.sendKeys(text);
    }

    static void clicar(By by){
        esperarElemento(by);
        elemento(by).click();
    }

    static void clicarModal(By by){
        waitForElementToBeClickable(by);
        elemento(by).click();
    }

    protected static String lerTexto(By by){
        esperarElemento(by);
        return elemento(by).getText();
    }

    protected static void tab(By by){
        esperarElemento(by);
        elemento(by).sendKeys("\t");
    }
}
