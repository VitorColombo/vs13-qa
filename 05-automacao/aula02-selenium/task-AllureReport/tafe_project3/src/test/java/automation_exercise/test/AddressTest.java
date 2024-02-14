package automation_exercise.test;

import automation_exercise.page.*;
import com.vemser.php_travel.data.dto.AddressDto;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.AddressData;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;

@Epic("Address")
public class AddressTest extends BaseTest {
    HomePage homePage = new HomePage();
    AuthenticationPage authenticationPage = new AuthenticationPage();
    AddressPage addressPage = new AddressPage();
    AddressData addressData = new AddressData();
    MyAccountPage myAccountPage = new MyAccountPage();
    MyAddressesPage myAddressesPage = new MyAddressesPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    private final CreateAccountData createAccountData = new CreateAccountData();

    @Test
    @Feature("Create Address")
    @Story("Create Address with valid data")
    public void testCreateAddressWithValidData() {
        CreateAccountDto account = createAccountData.createAccountValidData();
        AddressDto addressDto = addressData.addressDadosDinamicos();

        homePage.navigateToSignIn();

        authenticationPage.fillEmailCreate(account.getEmail());
        authenticationPage.clickCreateAnAccount();
        createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        myAccountPage.clickAddMyFirstAddress();
        addressPage.fillAddressFields(addressDto.getAddress(), addressDto.getCompany(), addressDto.getCity(), addressDto.getZip(), addressDto.getPhone());

        String msg = myAddressesPage.validatePage();

        Assert.assertEquals("MY ADDRESSES", msg);
        Assert.assertEquals(addressDto.getAddress(), myAddressesPage.getMyAddress());
    }

    @Test
    @Feature("Create Address")
    @Story("Create Address with invalid data")
    public void testCreateAddressWithoutData() {
        AddressDto addressDto = addressData.addressEmptyData();
        CreateAccountDto account = createAccountData.createAccountValidData();

        homePage.navigateToSignIn();

        authenticationPage.fillEmailCreate(account.getEmail());
        authenticationPage.clickCreateAnAccount();
        createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        myAccountPage.clickAddMyFirstAddress();
        addressPage.fillAddressFields(addressDto.getAddress(), addressDto.getCompany(), addressDto.getCity(), addressDto.getZip(), addressDto.getPhone());

        String msg = addressPage.getInvalidFieldsMsg();

        Assert.assertEquals("There are 4 errors", msg);
    }
}




