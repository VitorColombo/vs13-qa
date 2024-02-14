package automation_exercise.page;

import org.openqa.selenium.By;

import static com.vemser.php_travel.data.factory.seleniumfactory.Elements.waitForElementToBeClickable;

public class WomenCategoryPage {
    public static final By pageValidation = By.cssSelector("#categories_block_left > h2");
    public static final By addToCart1Btn = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > div.button-container > span > span");
    public static final By more1Btn = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > div.button-container > a > span");
    public static final By hoverProduct1 = By.cssSelector("a[title='Faded Short Sleeve T-shirts'] > img[alt='Faded Short Sleeve T-shirts']");
    public String validatePage(){
        return BasePage.lerTexto(pageValidation);
    }

    public void clickAddToCart1Btn(){
        BasePage.clicar(addToCart1Btn);
    }
    public void clickMore1Btn(){
        BasePage.hoverElemento(hoverProduct1);
        waitForElementToBeClickable(more1Btn);
        BasePage.clicar(more1Btn);
    }

}
