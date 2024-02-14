package com.vemser.php_travel.data.factory.datafaker;

import com.vemser.php_travel.data.dto.CreateAccountDto;
import com.vemser.php_travel.util.DataFakerGenerator;

public class CreateAccountData {
    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public CreateAccountDto createAccountValidData() {
        CreateAccountDto createAccountDto = new CreateAccountDto();

        createAccountDto.setEmail(dataFakerGenerator.emailFaker());
        createAccountDto.setTitle(dataFakerGenerator.titleFaker());
        createAccountDto.setFirstName(dataFakerGenerator.firstNameFaker());
        createAccountDto.setLastName(dataFakerGenerator.lastNameFaker());
        createAccountDto.setPassword(dataFakerGenerator.passwordFaker());

        return createAccountDto;
    }
}
