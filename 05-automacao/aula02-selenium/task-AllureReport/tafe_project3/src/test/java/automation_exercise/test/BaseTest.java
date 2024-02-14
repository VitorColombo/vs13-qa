package automation_exercise.test;

import com.vemser.php_travel.data.factory.seleniumfactory.SeleniumFactory;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    SeleniumFactory seleniumFactory = new SeleniumFactory();
    @Before
    public void abrirNavegador(){
        seleniumFactory.abrirNavegador("http://www.automationpractice.pl/index.php");
    }

    @After
    public void fecharNavegador(){
        seleniumFactory.fecharNavegador();
    }

}
