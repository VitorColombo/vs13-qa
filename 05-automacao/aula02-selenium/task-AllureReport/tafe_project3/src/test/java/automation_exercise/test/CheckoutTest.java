package automation_exercise.test;

import automation_exercise.page.*;
import com.vemser.php_travel.data.dto.AddressDto;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.AddressData;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import static com.vemser.php_travel.data.factory.seleniumfactory.SeleniumFactory.driver;

public class CheckoutTest extends BaseTest {

    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    AuthenticationPage authPage = new AuthenticationPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    CreateAccountData createAccountData = new CreateAccountData();
    WomenCategoryPage womenCategoryPage = new WomenCategoryPage();
    ProductPage productPage = new ProductPage();
    OrderPage orderPage = new OrderPage();
    AddressPage addressPage = new AddressPage();
    AddressData addressData = new AddressData();

    @Test
    public void testCheckoutWithAccountSetted() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        homePage.navigateToSignIn();

        CreateAccountDto account = createAccountData.createAccountValidData();

        authPage.fillEmailCreate(account.getEmail());
        authPage.clickCreateAnAccount();
        createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        myAccountPage.clickAddMyFirstAddress();
        AddressDto addressDto = addressData.addressDadosDinamicos();
        addressPage.fillAddressFields(addressDto.getAddress(), addressDto.getCompany(), addressDto.getCity(), addressDto.getZip(), addressDto.getPhone());

        myAccountPage.clickWomenBtn();
        String msg = womenCategoryPage.validatePage();
        Assert.assertEquals("WOMEN", msg);
        js.executeScript("window.scrollTo(0, 800)");
        womenCategoryPage.clickMore1Btn();
        js.executeScript("window.scrollTo(0, 300)");
        productPage.selectSizeM();
        productPage.clickAddToCartBtn();

        productPage.clickProceedToCheckoutBtn();
        String validateMsg = orderPage.validatePage();
        Assert.assertTrue(validateMsg.contains("SHOPPING-CART SUMMARY"));
        orderPage.clickProceedToCheckoutBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickProceedToCheckoutAddressBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickTermsOfServiceCheckbox();
        orderPage.clickProceedToCheckoutShippingBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickPayByBankWireBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickConfirmMyOrderBtn();
        String orderMsg = orderPage.validateOrderConfirmationMsg();
        Assert.assertTrue(orderMsg.contains("Your order on My Shop is complete."));
    }

    @Test
    public void testCheckoutWithoutAddress() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        homePage.navigateToSignIn();
        CreateAccountDto account = createAccountData.createAccountValidData();

        authPage.fillEmailCreate(account.getEmail());
        authPage.clickCreateAnAccount();
        createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        String msg = myAccountPage.validatePage();
        Assert.assertEquals("MY ACCOUNT", msg);

        myAccountPage.clickWomenBtn();
        msg = womenCategoryPage.validatePage();
        Assert.assertEquals("WOMEN", msg);
        js.executeScript("window.scrollTo(0, 800)");
        womenCategoryPage.clickMore1Btn();
        js.executeScript("window.scrollTo(0, 300)");
        productPage.selectSizeM();
        productPage.clickAddToCartBtn();

        productPage.clickProceedToCheckoutBtn();
        String validateMsg = orderPage.validatePage();
        Assert.assertTrue(validateMsg.contains("SHOPPING-CART SUMMARY"));
        orderPage.clickProceedToCheckoutBtn();
        js.executeScript("window.scrollTo(0, 300)");
        AddressDto addressDto = addressData.addressDadosDinamicos();
        addressPage.fillAddressFields(addressDto.getAddress(), addressDto.getCompany(), addressDto.getCity(), addressDto.getZip(), addressDto.getPhone());
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickProceedToCheckoutAddressBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickTermsOfServiceCheckbox();
        orderPage.clickProceedToCheckoutShippingBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickPayByBankWireBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickConfirmMyOrderBtn();
        String orderMsg = orderPage.validateOrderConfirmationMsg();
        Assert.assertTrue(orderMsg.contains("Your order on My Shop is complete."));
    }

    @Test
    public void testCheckoutWithoutAnUser() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        myAccountPage.clickWomenBtn();
        String msg = womenCategoryPage.validatePage();
        Assert.assertEquals("WOMEN", msg);
        js.executeScript("window.scrollTo(0, 800)");
        womenCategoryPage.clickMore1Btn();
        js.executeScript("window.scrollTo(0, 300)");
        productPage.selectSizeM();
        productPage.clickAddToCartBtn();

        productPage.clickProceedToCheckoutBtn();
        String validateMsg = orderPage.validatePage();
        Assert.assertTrue(validateMsg.contains("SHOPPING-CART SUMMARY"));
        orderPage.clickProceedToCheckoutBtn();
        homePage.navigateToSignIn();

        CreateAccountDto account = createAccountData.createAccountValidData();

        authPage.fillEmailCreate(account.getEmail());
        authPage.clickCreateAnAccount();
        createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickProceedToCheckoutBtn();

        AddressDto addressDto = addressData.addressDadosDinamicos();
        addressPage.fillAddressFields(addressDto.getAddress(), addressDto.getCompany(), addressDto.getCity(), addressDto.getZip(), addressDto.getPhone());
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickProceedToCheckoutAddressBtn();

        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickTermsOfServiceCheckbox();
        orderPage.clickProceedToCheckoutShippingBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickPayByBankWireBtn();
        js.executeScript("window.scrollTo(0, 800)");
        orderPage.clickConfirmMyOrderBtn();
        String orderMsg = orderPage.validateOrderConfirmationMsg();
        Assert.assertTrue(orderMsg.contains("Your order on My Shop is complete."));
    }
}
