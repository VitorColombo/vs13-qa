package com.vemser.php_travel.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccountDto {
    private int title;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
