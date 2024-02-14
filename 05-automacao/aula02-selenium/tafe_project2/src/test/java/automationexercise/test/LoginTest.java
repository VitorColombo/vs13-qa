package automationexercise.test;

import automationexercise.data.factory.datafaker.LoginData;
import automationexercise.data.dto.LoginDto;
import automationexercise.page.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    LoginData loginData = new LoginData();

    //metodos mais explicitos que mostram detalham o fluxo de teste
    @Test
    public void validarLoginDadosValidos() {
        LoginDto usuario = loginData.loginDadosValidos();
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.clicarBtnAcessar();
        String msg = loginPage.validarTextoBtnAposLogin();
        Assert.assertEquals("Logout", msg);
    }

    @Test
    public void validarLoginDadosInvalidos(){
        LoginDto usuario = loginData.loginDadosDinamicos();
        loginPage.preencherCampoSenha(usuario.getSenha());
        loginPage.preencherCampoEmail(usuario.getEmail());
        loginPage.clicarBtnAcessar();
        String msg = loginPage.validarMsgmEmailIncorreto();
        Assert.assertEquals("Your email or password is incorrect!", msg);
    }

    //metodos mais concisos que entram nos fluxos de teste
    @Test
    public void validarLoginDadosValidos2() {
        LoginDto usuario = loginData.loginDadosValidos();
        String msg = loginPage.fazerLogin(usuario.getEmail(), usuario.getSenha());
        Assert.assertEquals("Logout", msg);
    }

    @Test
    public void validarLoginDadosInvalidos2(){
        LoginDto usuario = loginData.loginDadosDinamicos();
        String msg = loginPage.loginEmailIncorreto(usuario.getEmail(), usuario.getSenha());
        Assert.assertEquals("Your email or password is incorrect!", msg);
    }
}
