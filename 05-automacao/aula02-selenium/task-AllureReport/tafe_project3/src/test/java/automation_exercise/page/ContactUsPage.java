package automation_exercise.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {

    private final By pageValidation = By.cssSelector("#center_column > form > fieldset > h3");
    private final By subjectInputSelector = By.cssSelector("#id_contact");
    private final By emailInputSelector = By.cssSelector("#email");
    private final By orderReferenteInputSelector = By.cssSelector("#id_order");
    private final By fileInputSelector = By.cssSelector("#fileUpload");
    private final By messageTextareaSelector = By.cssSelector("#message");
    private final By sendBtn = By.cssSelector("#submitMessage");
    private final By sucessMessage = By.cssSelector("#center_column > p");
    private final By invalidEmailMessage = By.cssSelector("#center_column > div > ol > li");
    private final By homeIconBtn = By.cssSelector("#columns > div.breadcrumb.clearfix > a > i");

    public void selectSubjectOption(int index) {
        Select dropdown = new Select(driver.findElement(subjectInputSelector));

        dropdown.selectByIndex(index);
    }

    public String fillCostumerServiceFields(int indexOption, String email, String orderReference, String fileName, String message) {
        selectSubjectOption(indexOption);

        preencherInput(emailInputSelector, email);
        preencherInput(orderReferenteInputSelector, orderReference);
        preencherInput(fileInputSelector, fileName);
        preencherInput(messageTextareaSelector, message);

        clicar(sendBtn);

        return lerTexto(sucessMessage);
    }

    public String fillCostumerServiceFieldsInvalidData(int indexOption, String email, String orderReference, String fileName, String message) {
        selectSubjectOption(indexOption);

        preencherInput(emailInputSelector, email);
        preencherInput(orderReferenteInputSelector, orderReference);
        preencherInput(fileInputSelector, fileName);
        preencherInput(messageTextareaSelector, message);

        clicar(sendBtn);

        return lerTexto(invalidEmailMessage);
    }

    public String validarContactUsPage() {
        return lerTexto(pageValidation);
    }

    public void clickHomeIcon() {
        clicar(homeIconBtn);
    }
}
