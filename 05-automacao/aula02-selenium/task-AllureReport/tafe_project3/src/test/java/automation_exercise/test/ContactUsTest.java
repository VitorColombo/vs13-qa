package automation_exercise.test;

import automation_exercise.page.ContactUsPage;
import automation_exercise.page.HomePage;
import com.vemser.php_travel.data.dto.ContactUsDto;
import com.vemser.php_travel.data.factory.datafaker.ContactUsData;
import org.junit.Assert;
import org.junit.Test;

public class ContactUsTest extends BaseTest {
    HomePage homePage = new HomePage();
    ContactUsPage contactUsPage = new ContactUsPage();
    ContactUsData contactUsData = new ContactUsData();

    @Test
    public void testContactCustomerServiceWithValidData(){
        homePage.clicarContactUs();

        String paginaValidaMsg = contactUsPage.validarContactUsPage();

        Assert.assertEquals("SEND A MESSAGE", paginaValidaMsg);

        ContactUsDto contactUsDto = contactUsData.contactUsDadosDinamicos();

        String msgContactUs = contactUsPage.fillCostumerServiceFields(contactUsDto.getSubjectType(),contactUsDto.getEmail(),contactUsDto.getOrderReference(),contactUsDto.getFileName(),contactUsDto.getMessage());

        Assert.assertEquals("Your message has been successfully sent to our team.",msgContactUs);

        homePage.clicarHomeButton();

    }
    @Test
    public void testContactCustomerServiceWithInValidData(){
        homePage.clicarContactUs();

        String paginaValidaMsg = contactUsPage.validarContactUsPage();

        Assert.assertEquals("SEND A MESSAGE", paginaValidaMsg);

        ContactUsDto contactUsDto = contactUsData.contactUsDadosInvalidos();

        String msgContactUs = contactUsPage.fillCostumerServiceFieldsInvalidData(contactUsDto.getSubjectType(),contactUsDto.getEmail(),contactUsDto.getOrderReference(),contactUsDto.getFileName(),contactUsDto.getMessage());

        Assert.assertEquals("Invalid email address.", msgContactUs);

        contactUsPage.clickHomeIcon();
    }
}
