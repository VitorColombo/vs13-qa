package com.vemser.php_travel.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
}
