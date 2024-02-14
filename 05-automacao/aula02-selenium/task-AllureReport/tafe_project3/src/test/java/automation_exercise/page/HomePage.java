package automation_exercise.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public static final By signInBtn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    public static final By signOutBtn = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    public static final By userNameValidation = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");
    public static final By contactUsBtn = By.cssSelector("#contact-link");
    public static final By homeBtn = By.cssSelector("#center_column > ul > li > a > span");
    public static final By myAccountBtn = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(1) > a > span");
    public static final By newsLetterInputSelector = By.cssSelector("#newsletter-input");
    public static final By newsLetterBtn = By.cssSelector("#newsletter_block_left > div > form > div > button");
    public static final By newLetterMessage = By.cssSelector("#columns > p");
    public void navigateToSignIn() {
        clicar(signInBtn);
    }

    public void clicarSignOut(){
        clicar(signOutBtn);
    }
    public void clicarContactUs(){
        clicar(contactUsBtn);
    }
    public void clicarHomeButton(){
        clicar(homeBtn);
    }
    public boolean validarUsuarioLogado(String userName){
        String usernameHeader = lerTexto(userNameValidation);
        return userName.equals(usernameHeader);
    }
    public void clicarAccountButton(){
        clicar(myAccountBtn);
    }
    public void fillNewsLetterData(String email){
        preencherInput(newsLetterInputSelector,email);
    }
    public void clicarNewsLetterButton(){
        clicar(newsLetterBtn);
    }
    public String validarNewsletterMessage(){
        return lerTexto(newLetterMessage);
    }


}
