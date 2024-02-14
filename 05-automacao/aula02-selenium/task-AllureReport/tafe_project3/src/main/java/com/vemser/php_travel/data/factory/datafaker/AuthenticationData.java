package com.vemser.php_travel.data.factory.datafaker;

import com.vemser.php_travel.data.dto.AuthenticationDto;
import com.vemser.php_travel.util.DataFakerGenerator;

public class AuthenticationData {
    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public AuthenticationDto createValidAuthentication() {
        AuthenticationDto authenticationDto = new AuthenticationDto();

        authenticationDto.setEmail(dataFakerGenerator.emailFaker());
        authenticationDto.setPassword(dataFakerGenerator.passwordFaker());

        return authenticationDto;
    }
}
