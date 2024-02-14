package com.vemser.php_travel.data.factory.datafaker;
import com.vemser.php_travel.data.dto.AddressDto;
import com.vemser.php_travel.util.DataFakerGenerator;

public class AddressData {

    DataFakerGenerator dataFakerGenerator = new DataFakerGenerator();

    public AddressDto addressDadosDinamicos(){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress(dataFakerGenerator.addressFaker());
        addressDto.setCity(dataFakerGenerator.cityFaker());
        addressDto.setZip(dataFakerGenerator.zipFaker());
        addressDto.setPhone(dataFakerGenerator.phoneFaker());
        return addressDto;
    }

    public AddressDto addressEmptyData(){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress("");
        addressDto.setCity("");
        addressDto.setZip("");
        addressDto.setPhone("");
        return addressDto;
    }
}
