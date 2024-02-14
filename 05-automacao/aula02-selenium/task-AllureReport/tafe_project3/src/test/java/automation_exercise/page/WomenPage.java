package automation_exercise.page;

import org.openqa.selenium.By;

public class WomenPage extends BasePage{

    private static final By signInBtn = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    private static final By womenBtn = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    private static final By card = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a");
    private static final By sizeSelect = By.cssSelector("#group_1");
    private static final By sizeM = By.cssSelector("#group_1 > option:nth-child(2)");
    private static final By quantityInput = By.cssSelector("#quantity_wanted");
    private static final By addToCartBtn = By.cssSelector("#add_to_cart > button");
    private static final By continueShoppingBtn = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span");
    private static final By cartBtn = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    private static final By productTitle = By.cssSelector("#product_1_3_0_0 > td.cart_description > p");
    private static final By quantityError = By.cssSelector("#product > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p");

    public void verifySignInBtn(){
        lerTexto(signInBtn);
    }
    public void clickWomenBtn(){
        clicar(womenBtn);
    }
    public void clickCard(){
         clicar(card);
    }
    public void clickSize(){
        clicar(sizeSelect);
    }
    public void clickSizeM(){
        clicar(sizeM);
    }
    public void fillQuantity(String quantity){
        clicar(quantityInput);
        preencherInput(quantityInput, quantity);
    }
    public void clickAddToCartBtn(){
        clicar(addToCartBtn);
    }
    public void clickContinueShoppingBtn(){
        clicarModal(continueShoppingBtn);
    }
    public void clickCartBtn(){
        clicar(cartBtn);
    }
    public String validateProdutoTitle(){
        return lerTexto(productTitle);
    }
    public String validateQuantityError(){
        return lerTexto(quantityError);
    }


}
