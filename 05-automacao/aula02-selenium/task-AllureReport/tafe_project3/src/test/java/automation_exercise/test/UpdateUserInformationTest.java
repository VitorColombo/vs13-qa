package automation_exercise.test;

import automation_exercise.page.*;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import org.junit.Assert;
import org.junit.Test;

public class UpdateUserInformationTest extends BaseTest {
    private final CreateAccountData createAccountData = new CreateAccountData();
    private final CreateAccountPage createAccountPage = new CreateAccountPage();
    private final HomePage homePage = new HomePage();
    private final AuthenticationPage authenticationPage = new AuthenticationPage();
    private final MyAccountPage myAccountPage = new MyAccountPage();
    private final MyPersonalInformationPage myPersonalInformationPage = new MyPersonalInformationPage();

    @Test
    public void testUpdateInformationWithValidPassword() {
        CreateAccountDto account = createAccountData.createAccountValidData();
        homePage.navigateToSignIn();

        authenticationPage.fillEmailCreate(account.getEmail());
        authenticationPage.clickCreateAnAccount();

        String msg = createAccountPage.createAccount(
            account.getTitle(),
            account.getFirstName(),
            account.getLastName(),
            account.getPassword()
        );

        Assert.assertEquals("Your account has been created.", msg);

        homePage.clicarHomeButton();

        homePage.clicarAccountButton();

        myAccountPage.clickMyInformationBtn();

        CreateAccountDto newAccountInformation = createAccountData.createAccountValidData();
        myPersonalInformationPage.fillUpdateData(newAccountInformation.getFirstName(), newAccountInformation.getLastName(), newAccountInformation.getEmail(), account.getPassword(), newAccountInformation.getPassword());

        myPersonalInformationPage.clickSaveInformation();

        String updateSuccessMessage = myPersonalInformationPage.validarSuccessMessage();

        Assert.assertEquals("Your personal information has been successfully updated.", updateSuccessMessage);

        homePage.clicarHomeButton();
    }
    @Test
    public void testUpdateInformationWithInvalidPassword() {
        CreateAccountDto account = createAccountData.createAccountValidData();
        homePage.navigateToSignIn();

        authenticationPage.fillEmailCreate(account.getEmail());
        authenticationPage.clickCreateAnAccount();

        String msg = createAccountPage.createAccount(
            account.getTitle(),
            account.getFirstName(),
            account.getLastName(),
            account.getPassword()
        );

        Assert.assertEquals("Your account has been created.", msg);

        homePage.clicarHomeButton();

        homePage.clicarAccountButton();

        myAccountPage.clickMyInformationBtn();

        CreateAccountDto newAccountInformation = createAccountData.createAccountValidData();
        myPersonalInformationPage.fillUpdateData(newAccountInformation.getFirstName(), newAccountInformation.getLastName(), newAccountInformation.getEmail(), newAccountInformation.getPassword(), newAccountInformation.getPassword());

        myPersonalInformationPage.clickSaveInformation();

        String updateErrorMessage = myPersonalInformationPage.validarErrorMessage();

        Assert.assertEquals("There is 1 error", updateErrorMessage);

        homePage.clicarHomeButton();
    }
}
