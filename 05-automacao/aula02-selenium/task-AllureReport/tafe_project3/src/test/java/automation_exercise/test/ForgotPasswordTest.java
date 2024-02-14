package automation_exercise.test;

import automation_exercise.page.AuthenticationPage;
import automation_exercise.page.CreateAccountPage;
import automation_exercise.page.HomePage;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
@Epic("Forgot Password")
public class ForgotPasswordTest extends BaseTest {
    private final CreateAccountData createAccountData = new CreateAccountData();
    private final HomePage homePage = new HomePage();
    private final AuthenticationPage authenticationPage = new AuthenticationPage();
    private final CreateAccountPage createAccountPage = new CreateAccountPage();


    @Test
    @Feature("Forgot Password")
    @Story("Forgot Password with valid data")
    public void testForgotPasswordValidData() {
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

        String fullNameAccount = account.getFirstName() + " " + account.getLastName();
        boolean usuarioLogado = homePage.validarUsuarioLogado(fullNameAccount);

        homePage.clicarSignOut();
        Assert.assertTrue(usuarioLogado);

        homePage.navigateToSignIn();

        authenticationPage.clickForgotPassword();

        authenticationPage.fillEmailForgotPassword(account.getEmail());

        authenticationPage.clickRetrievePasswordButton();

        String success = authenticationPage.validarMensagemForgotSuccess();

        Assert.assertEquals("A confirmation email has been sent to your address: " + account.getEmail(), success);
    }
    @Test
    @Feature("Forgot Password")
    @Story("Forgot Password with invalid email")
    public void testForgotPasswordNotRegisteredEmail() {
        CreateAccountDto account = createAccountData.createAccountEmailNotRegistered();
        homePage.navigateToSignIn();

        authenticationPage.clickForgotPassword();

        authenticationPage.fillEmailForgotPassword(account.getEmail());

        authenticationPage.clickRetrievePasswordButton();

        String errorMessage = authenticationPage.validarMensagemForgotSuccess();

        Assert.assertEquals("Please enter the email address you used to register. We will then send you a new password.", errorMessage);
    }

}
