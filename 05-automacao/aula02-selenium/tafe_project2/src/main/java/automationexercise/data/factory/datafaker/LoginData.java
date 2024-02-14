package automationexercise.data.factory.datafaker;

import automationexercise.data.dto.LoginDto;
import automationexercise.util.DataFakerGenerator;

public class LoginData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public LoginDto loginDadosValidos(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("vs@gmail.com");
        loginDto.setSenha("123456");
        return loginDto;
    }

    public LoginDto loginDadosDinamicos(){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(dataFakerGenerator.emailFaker());
        loginDto.setSenha(dataFakerGenerator.senhaFaker());
        return loginDto;
    }
}
