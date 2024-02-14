package automation_exercise.page;

import org.openqa.selenium.By;

public class AddressPage extends BasePage {
    private static final By addressField =
            By.cssSelector("#address1");
    private static final By cityField =
            By.cssSelector("#city");
    private static final By stateField =
            By.cssSelector("#id_state");
    private static final By zipCodeField =
            By.cssSelector("#postcode");
    private static final By mobilePhoneField =
            By.cssSelector("#phone");
    private static final By homePhoneField =
            By.cssSelector("#phone");
    private static final By companyField =
            By.cssSelector("#company");
    private static final By saveBtn =
            By.cssSelector("#submitAddress");
    private static final By stateOption =
            By.cssSelector("#id_state > option:nth-child(4)");
    private static final By invalidFieldsMsg = By.cssSelector("#center_column > div > div > p");

    public void fillAddressFields(String address, String company, String city, String zip, String phone) {
        preencherInput(addressField, address);
        preencherInput(companyField, company);
        preencherInput(cityField, city);
        preencherInput(zipCodeField, zip);
        preencherInput(mobilePhoneField, phone);
        preencherInput(homePhoneField, phone);
        clicar(stateField);
        clicar(stateOption);

        clicar(saveBtn);
    }

    public String getInvalidFieldsMsg() {
        return lerTexto(invalidFieldsMsg);
    }

}
