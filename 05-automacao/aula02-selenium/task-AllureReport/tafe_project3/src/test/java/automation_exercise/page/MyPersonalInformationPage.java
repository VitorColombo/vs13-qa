package automation_exercise.page;

import org.openqa.selenium.By;

public class MyPersonalInformationPage extends BasePage{

    private final By firstNameInputSelector = By.cssSelector("#firstname");
    private final By lastNameInputSelector = By.cssSelector("#lastname");
    private final By emailInputSelector = By.cssSelector("#email");
    private final By oldPasswordInputSelector = By.cssSelector("#old_passwd");
    private final By newPasswordInputSelector = By.cssSelector("#passwd");
    private final By saveBtn = By.cssSelector("#center_column > div > form > fieldset > div:nth-child(10) > button");
    private final By successMessage = By.cssSelector("#center_column > div > p");
    private final By errorMessage = By.cssSelector("#center_column > div > div > p");

    public void fillUpdateData(String firstName, String lastName,String email,String oldPassword,String newPassword){
        preencherInput(firstNameInputSelector,firstName);
        preencherInput(lastNameInputSelector,lastName);
        preencherInput(emailInputSelector,email);
        preencherInput(oldPasswordInputSelector,oldPassword);
        //preencherInput(newPasswordInputSelector,newPassword);
    }
    public void clickSaveInformation(){
        clicar(saveBtn);
    }
    public String validarSuccessMessage(){
        return lerTexto(successMessage);
    }
    public String validarErrorMessage(){
        return lerTexto(errorMessage);
    }

}
