package automationexercise.test;

import automationexercise.data.factory.seleniumfactory.SeleniumFactory;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    SeleniumFactory seleniumFactory = new SeleniumFactory();

    @Before
    public void abrirNavagador(){
        seleniumFactory.initBrowser("https://automationexercise.com");
    }

    @After
    public void fecharNavegador(){
        seleniumFactory.tearDown();
    }
}
