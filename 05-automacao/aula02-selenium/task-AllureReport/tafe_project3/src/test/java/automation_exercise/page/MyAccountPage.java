package automation_exercise.page;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {
    public static final By addMyFirstAddressBtn = By.cssSelector("#center_column > div > div > ul > li:nth-child(1) > a > span");
    public static final By homeBtn = By.cssSelector("#center_column > ul > li > a > span");
    public static final By pageValidation = By.cssSelector("#center_column > h1");
    public static final By womenBtn = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    public static final By myPersonalInformationByn = By.cssSelector("#center_column > div > div > ul > li:nth-child(5) > a");
    public void clickAddMyFirstAddress(){
        clicar(addMyFirstAddressBtn);
    }
    public void clickHomeButton(){
        BasePage.clicar(homeBtn);
    }

    public String validatePage(){
        return BasePage.lerTexto(pageValidation);
    }

    public void clickWomenBtn(){
        BasePage.clicar(womenBtn);
    }
    public void clickMyInformationBtn(){
        BasePage.clicar(myPersonalInformationByn);
    }

}
