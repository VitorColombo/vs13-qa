package com.vemser.php_travel.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactUsDto {
    private Integer subjectType;
    private String email;
    private String orderReference;
    private String fileName;
    private String message;


}
