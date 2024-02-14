package automation_exercise.test;

import automation_exercise.page.HomePage;
import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.data.factory.datafaker.CreateAccountData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
@Epic("NewsLetter Subscription")
public class NewsLetterSubscriptionTest extends BaseTest {
    HomePage homePage = new HomePage();
    CreateAccountData createAccountData = new CreateAccountData();

    @Test
    @Feature("NewsLetter Subscription")
    @Story("NewsLetter Subscription with valid email")
    public void testNewsletterSubscriptionWithValidEmail() {
        CreateAccountDto accountDto = createAccountData.createAccountValidData();
        homePage.fillNewsLetterData(accountDto.getEmail());

        homePage.clicarNewsLetterButton();

        String successMessage = homePage.validarNewsletterMessage();

        Assert.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", successMessage);
    }

    @Test
    @Feature("NewsLetter Subscription")
    @Story("NewsLetter Subscription with invalid email")
    public void testNewsletterSubscriptionWithInvalidEmail() {
        CreateAccountDto accountDto = createAccountData.createAccountEmailOnly();
        homePage.fillNewsLetterData(accountDto.getEmail());

        homePage.clicarNewsLetterButton();

        String errorMessage = homePage.validarNewsletterMessage();

        Assert.assertEquals("Newsletter : Invalid email address.", errorMessage);
    }
}
