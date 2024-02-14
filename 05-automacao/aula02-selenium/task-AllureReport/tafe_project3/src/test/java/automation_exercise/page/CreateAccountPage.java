package automation_exercise.page;


import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {
    private final String titleInputWithoutNumberSelector = "#id_gender";
    private final By firstNameInputSelector = By.cssSelector("#customer_firstname");
    private final By lastnameInputSelector = By.cssSelector("#customer_lastname");
    private final By emailInputSelector = By.cssSelector("#email");
    private final By passwordInputSelector = By.cssSelector("#passwd");
    private final By birthDayInputSelector = By.cssSelector("#days");
    private final By birthDayOptionsSelector = By.cssSelector("#days > option:nth-child(23)");
    private final By birthMonthInputSelector = By.cssSelector("#months");
    private final By birthMonthOptionsSelector = By.cssSelector("#months > option:nth-child(9)");
    private final By birthYearInputSelector = By.cssSelector("#years");
    private final By birthYearOptionsSelector = By.cssSelector("#years > option:nth-child(29)");
    private final By registerButtonSelector = By.cssSelector("#submitAccount");
    private final By successMessageSelector = By.cssSelector("#center_column > p.alert.alert-success");
    private final By errorMessageSelector = By.cssSelector("#center_column > div > ol > li");


    public String createAccount(int title, String firstName, String lastName, String password) {
        clicar(By.cssSelector(titleInputWithoutNumberSelector + title));
        preencherInput(firstNameInputSelector, firstName);
        preencherInput(lastnameInputSelector, lastName);
        preencherInput(passwordInputSelector, password);

        clicar(birthDayInputSelector);
        clicar(birthDayOptionsSelector);

        clicar(birthMonthInputSelector);
        clicar(birthMonthOptionsSelector);

        clicar(birthYearInputSelector);
        clicar(birthYearOptionsSelector);

        clicar(registerButtonSelector);

        return lerTexto(successMessageSelector);
    }

    public String createAccountWithInvalidEmail(int title, String firstName, String lastName, String password) {
        clicar(By.cssSelector(titleInputWithoutNumberSelector + title));
        preencherInput(firstNameInputSelector, firstName);
        preencherInput(lastnameInputSelector, lastName);
        preencherInput(emailInputSelector, "email_invalido");
        preencherInput(passwordInputSelector, password);

        clicar(birthDayInputSelector);
        clicar(birthDayOptionsSelector);

        clicar(birthMonthInputSelector);
        clicar(birthMonthOptionsSelector);

        clicar(birthYearInputSelector);
        clicar(birthYearOptionsSelector);

        clicar(registerButtonSelector);

        return lerTexto(errorMessageSelector);
    }
}
