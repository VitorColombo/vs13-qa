package automation_exercise.page;

import org.openqa.selenium.By;


public class AuthenticationPage extends BasePage {
    public final By emailField = By.cssSelector("#email");
    public final By passwordField = By.cssSelector("#passwd");
    public final By signInBtn = By.cssSelector("#SubmitLogin > span");
    public final By createAccountBtn = By.cssSelector("#SubmitCreate > span");
    public final By emailCreateField = By.cssSelector("#email_create");
    public final By titleOfMyAccountPage = By.cssSelector("#center_column > h1");
    public final By errorMessageSelector = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");
    public final By forgotPasswordBtn = By.cssSelector("#login_form > div > p.lost_password.form-group > a");
    private final By forgotPasswordValidation = By.cssSelector("#center_column > div > h1");
    private final By retrievePasswordBtn = By.cssSelector("#form_forgotpassword > fieldset > p > button");
    private final By forgotPasswordSuccessMessage = By.cssSelector("#center_column > div > p");

    public void fillEmailCreate(String email) {
        preencherInput(emailCreateField, email);
    }

    public void clickCreateAnAccount() {
        clicar(createAccountBtn);
    }

    public String login(String email, String password) {
        preencherInput(emailField, email);
        preencherInput(passwordField, password);
        clicar(signInBtn);

        return lerTexto(titleOfMyAccountPage);
    }

    public String loginWithInvalidEmail(String email, String password) {
        preencherInput(emailField, email);
        preencherInput(passwordField, password);
        clicar(signInBtn);

        return lerTexto(errorMessageSelector);
    }

    public void clickForgotPassword() {
        clicar(forgotPasswordBtn);
    }

    public String validateForgotPassword() {
        return lerTexto(forgotPasswordValidation);
    }

    public void fillEmailForgotPassword(String email) {
        preencherInput(emailField, email);
    }

    public void clickRetrievePasswordButton() {
        clicar(retrievePasswordBtn);
    }
    public String validarMensagemForgotSuccess(){
        return lerTexto(forgotPasswordSuccessMessage);
    }

}
