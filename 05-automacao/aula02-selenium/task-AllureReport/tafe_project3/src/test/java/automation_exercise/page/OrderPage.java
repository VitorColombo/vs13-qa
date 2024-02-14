package automation_exercise.page;

import org.openqa.selenium.By;

public class OrderPage extends BasePage{
    private static final By pageValidation = By.cssSelector("#cart_title");
    private static final By proceedToCheckoutBtn = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span");
    private static final By proceedToCheckoutAddressBtn = By.cssSelector("#center_column > form > p > button > span");
    private static final By proceedToCheckoutShippingBtn = By.cssSelector("#form > p > button > span");
    private static final By confirmMyOrderBtn = By.cssSelector("#cart_navigation > button");
    private static final By termsOfServiceCheckbox = By.cssSelector("#form > div > p.checkbox > label");
    private static final By payByBankWireBtn = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    private static  final By orderConfirmationMsg = By.cssSelector("#center_column > p.alert.alert-success");
    public String validatePage(){
        return BasePage.lerTexto(pageValidation);
    }
    public void clickProceedToCheckoutBtn(){
        waitForElementToBeClickable(proceedToCheckoutBtn);
        clicar(proceedToCheckoutBtn);
    }
    public void clickProceedToCheckoutAddressBtn(){
        waitForElementToBeClickable(proceedToCheckoutAddressBtn);
        clicar(proceedToCheckoutAddressBtn);
    }
    public void clickProceedToCheckoutShippingBtn(){
        waitForElementToBeClickable(proceedToCheckoutShippingBtn);
        clicar(proceedToCheckoutShippingBtn);
    }
    public void clickTermsOfServiceCheckbox(){
        waitForElementToBeClickable(termsOfServiceCheckbox);
        clicar(termsOfServiceCheckbox);
    }
    public void clickPayByBankWireBtn(){
        waitForElementToBeClickable(payByBankWireBtn);
        clicar(payByBankWireBtn);
    }
    public void clickConfirmMyOrderBtn(){
        waitForElementToBeClickable(confirmMyOrderBtn);
        clicar(confirmMyOrderBtn);
    }
    public String validateOrderConfirmationMsg(){
        return lerTexto(orderConfirmationMsg);
    }
}
