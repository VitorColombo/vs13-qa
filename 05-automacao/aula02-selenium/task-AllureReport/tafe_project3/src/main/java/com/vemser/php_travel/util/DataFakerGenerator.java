package com.vemser.php_travel.util;

import com.github.javafaker.Faker;

public class DataFakerGenerator {
    private static final Faker faker = new Faker();

    public String emailFaker() {
        return faker.internet().emailAddress();
    }
    public String passwordFaker() {
        return faker.internet().password();
    }
    public int titleFaker() {
        return faker.number().numberBetween(1, 2);
    }
    public String firstNameFaker() {
        return faker.name().firstName();
    }
    public String lastNameFaker() {
        return faker.name().lastName();
    }
    public String addressFaker() {
        return faker.address().fullAddress();
    }
    public String cityFaker() {
        return faker.address().city();
    }
    public String companyFaker() {
        return faker.company().name();
    }
    public String phoneFaker() {
        return faker.phoneNumber().cellPhone();
    }
    public String zipFaker() {
        return faker.number().digits(5);
    }
    public String messageFaker(){
        return faker.lorem().paragraph();
    }

    public int numberRandomInRange(int min, int max){
        return faker.number().numberBetween(min,max);
    }
    public String orderIdFaker(){
        return faker.idNumber().valid();
    }
}
