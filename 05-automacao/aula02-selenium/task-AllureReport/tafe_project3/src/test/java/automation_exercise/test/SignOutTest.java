package automation_exercise.test;

import automation_exercise.page.AuthenticationPage;
import automation_exercise.page.CreateAccountPage;
import automation_exercise.page.HomePage;
import automation_exercise.page.MyAccountPage;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import org.junit.Assert;
import org.junit.Test;

public class SignOutTest extends BaseTest {
    HomePage homePage = new HomePage();
    AuthenticationPage authPage = new AuthenticationPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    private final CreateAccountData createAccountData = new CreateAccountData();

    @Test
    public void validateSignOutBeforeCreatingAccount() {
        CreateAccountDto account = createAccountData.createAccountValidData();

        homePage.navigateToSignIn();

        authPage.fillEmailCreate(account.getEmail());
        authPage.clickCreateAnAccount();
        String msgCreatedAccount = createAccountPage.createAccount(account.getTitle(), account.getFirstName(), account.getLastName(), account.getPassword());

        Assert.assertEquals("Your account has been created.", msgCreatedAccount);

        myAccountPage.clickHomeButton();

        String fullNameAccount = account.getFirstName() + " " + account.getLastName();
        boolean usuarioLogado = homePage.validarUsuarioLogado(fullNameAccount);

        homePage.clicarSignOut();
        Assert.assertTrue(usuarioLogado);
    }
}
