package automation_exercise.test;

import automation_exercise.page.AuthenticationPage;
import automation_exercise.page.CreateAccountPage;
import automation_exercise.page.HomePage;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import org.junit.Assert;
import org.junit.Test;

public class CreateAccountTest extends BaseTest{
    private final CreateAccountPage createAccountPage = new CreateAccountPage();
    private final CreateAccountData createAccountData = new CreateAccountData();
    private final AuthenticationPage authenticationPage = new AuthenticationPage();
    private final HomePage homePage = new HomePage();

    @Test
    public void validateCreationOfAccountWithValidData() {
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
    }

    @Test
    public void validateCreationOfAccountWithInvalidEmail() {
        CreateAccountDto account = createAccountData.createAccountValidData();

        homePage.navigateToSignIn();

        authenticationPage.fillEmailCreate(account.getEmail());
        authenticationPage.clickCreateAnAccount();

        String msg = createAccountPage.createAccountWithInvalidEmail(
                account.getTitle(),
                account.getFirstName(),
                account.getLastName(),
                account.getPassword()
        );

        Assert.assertEquals("email is invalid.", msg);
    }
}

