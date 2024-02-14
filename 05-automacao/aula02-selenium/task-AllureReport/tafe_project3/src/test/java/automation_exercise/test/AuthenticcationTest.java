package automation_exercise.test;

import automation_exercise.page.AuthenticationPage;
import automation_exercise.page.CreateAccountPage;
import automation_exercise.page.HomePage;
import automation_exercise.page.MyAccountPage;
import com.vemser.php_travel.data.dto.AuthenticationDto;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.AuthenticationData;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;

@Epic("Authentication")
public class AuthenticcationTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private AuthenticationPage authPage = new AuthenticationPage();
    private AuthenticationData authData = new AuthenticationData();
    private CreateAccountData createAccountData = new CreateAccountData();
    private CreateAccountPage createAccountPage = new CreateAccountPage();
    private MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    @Feature("Create Account")
    @Story("Create Account with valid data")
    public void validateLoginWithValidData() {
        CreateAccountDto account = createAccountData.createAccountValidData();

        homePage.navigateToSignIn();

        authPage.fillEmailCreate(account.getEmail());
        authPage.clickCreateAnAccount();
        createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        homePage.clicarSignOut();
        homePage.navigateToSignIn();

        String msg = authPage.login(account.getEmail(), account.getPassword());

        Assert.assertEquals("MY ACCOUNT", msg);
    }

    @Test
    @Feature("Create Account")
    @Story("Create Account with invalid email")
    public void validateLoginWithInvalidEmail() {

        AuthenticationDto auth = authData.createValidAuthentication();

        homePage.navigateToSignIn();

        String msg = authPage.loginWithInvalidEmail(auth.getEmail(), auth.getPassword());
        Assert.assertEquals("Authentication failed.", msg);
    }
}
