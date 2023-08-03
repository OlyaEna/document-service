package ru.aston.documentservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String  id;
    private String country;
    private String city;
    private String streetName;
    private String streetNumber;
    private String postCode;

}
