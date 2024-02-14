package automation_exercise.page;

import org.openqa.selenium.By;


public class AuthenticationPage extends BasePage {
    public static final By emailField = By.cssSelector("#email");
    public static final By passwordField = By.cssSelector("#passwd");
    public static final By signInBtn = By.cssSelector("#SubmitLogin > span");
    public static final By createAccountBtn = By.cssSelector("#SubmitCreate > span");
    public static final By emailCreateField = By.cssSelector("#email_create");
    public static final By titleOfMyAccountPage = By.cssSelector("#center_column > h1");
    public static final By errorMessageSelector = By.cssSelector("#center_column > div.alert.alert-danger > ol > li");

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
}
