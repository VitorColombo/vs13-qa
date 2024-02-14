package automation_exercise.page;

import org.openqa.selenium.By;

import static automation_exercise.page.BasePage.lerTexto;

public class MyAddressesPage {
    public static final By myAddress = By.cssSelector("#center_column > div.addresses > div > div > ul > li:nth-child(4) > span.address_address1");
    public static final By pageValidation = By.cssSelector("#center_column > h1");

    public String validatePage(){
        return lerTexto(pageValidation);
    }
    public String getMyAddress(){
        return lerTexto(myAddress);
    }
}
