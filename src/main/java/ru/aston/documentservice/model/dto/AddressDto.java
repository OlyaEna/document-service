package ru.aston.documentservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String  id;
    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postCode;
}
