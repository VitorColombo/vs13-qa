package com.vemser.php_travel.data.factory.datafaker;

import com.vemser.php_travel.data.dto.ContactUsDto;
import com.vemser.php_travel.util.DataFakerGenerator;

import java.io.File;

public class ContactUsData {
    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();
    public ContactUsDto contactUsDadosDinamicos(){
        ContactUsDto contactUsDto = new ContactUsDto();
        contactUsDto.setSubjectType(dataFakerGenerator.numberRandomInRange(1,2));
        contactUsDto.setEmail(dataFakerGenerator.emailFaker());
        contactUsDto.setOrderReference(dataFakerGenerator.orderIdFaker());
        File fileFake = new File("src/test/resources/ContactUsFile.txt");
        contactUsDto.setFileName(fileFake.getAbsolutePath());
        contactUsDto.setMessage(dataFakerGenerator.messageFaker());

        return contactUsDto;
    }
    public ContactUsDto contactUsDadosInvalidos(){
        ContactUsDto contactUsDto = new ContactUsDto();
        contactUsDto.setSubjectType(dataFakerGenerator.numberRandomInRange(1,2));
        contactUsDto.setEmail("teste");
        contactUsDto.setOrderReference(dataFakerGenerator.orderIdFaker());
        File fileFake = new File("src/test/resources/ContactUsFile.txt");
        contactUsDto.setFileName(fileFake.getAbsolutePath());
        contactUsDto.setMessage(dataFakerGenerator.messageFaker());

        return contactUsDto;
    }

}
