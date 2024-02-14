package automation_exercise.test;

import automation_exercise.page.WomenPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import static com.vemser.php_travel.data.factory.seleniumfactory.SeleniumFactory.driver;

@Epic("Women Test")
public class WomenTest extends BaseTest{

    WomenPage womenPage = new WomenPage();

    @Test
    @Feature("Adicionar produto ao carrinho")
    @Story("Adicionar produto ao carrinho com sucesso")
    public void validateProductAdditionToCart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        womenPage.verifySignInBtn();
        womenPage.clickWomenBtn();
        womenPage.clickCard();
        womenPage.clickSize();
        womenPage.clickSizeM();
        womenPage.clickAddToCartBtn();
        js.executeScript("window.scrollBy(0,500)");
        womenPage.clickContinueShoppingBtn();
        womenPage.clickCartBtn();
        String productTitle = womenPage.validateProdutoTitle();

        Assert.assertEquals("Faded Short Sleeve T-shirts", productTitle);
    }

    @Test
    @Feature("Adicionar produto ao carrinho")
    @Story("Adicionar produto ao carrinho com quantidade inválida")
    public void validateProductAdditionToCartWithInvalidQuantity(){

        womenPage.verifySignInBtn();
        womenPage.clickWomenBtn();
        womenPage.clickCard();
        womenPage.clickSize();
        womenPage.clickSizeM();
        womenPage.fillQuantity("0");
        womenPage.clickAddToCartBtn();
        String errorMsg = womenPage.validateQuantityError();

        Assert.assertEquals("Null quantity.", errorMsg);
    }
}
