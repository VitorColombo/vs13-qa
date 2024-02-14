package automation_exercise.page;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    private static final By addToCartBtn = By.cssSelector("#add_to_cart > button > span");
    private static final By sizeSelector = By.cssSelector("#group_1");
    private static final By sizeM = By.cssSelector("#group_1 > option:nth-child(2)");
    private static final By msgProductAdded = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2");
    public static final By proceedToCheckoutBtn = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span");
    public static final By colorSelector = By.cssSelector("#color_14");
    public void clickAddToCartBtn(){
        clicar(addToCartBtn);
    }
    public void selectSizeM(){
        clicar(sizeSelector);
        clicar(sizeM);
    }
    public String validateMsgProductAdded(){
        return lerTexto(msgProductAdded);
    }
    public void clickProceedToCheckoutBtn(){
        waitForElementToBeClickable(proceedToCheckoutBtn);
        clicar(proceedToCheckoutBtn);
    }
    public void clickColorSelector(){
        waitForElementToBeClickable(colorSelector);
        clicar(colorSelector);
    }

}
