package automationexercise.util;

import com.github.javafaker.Faker;

public class DataFakerGenerator {

    private static final Faker faker = new Faker();
    public String emailFaker(){
        return faker.internet().emailAddress();
    }
    public static String senhaFaker(){
        return faker.internet().password();
    }
}
