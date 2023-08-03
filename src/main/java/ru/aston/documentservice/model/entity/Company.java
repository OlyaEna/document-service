package ru.aston.documentservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    private String id;
    private FormOwnership formOwnership;
    private Address address;
    private String occupation;
    private Long personnel;
    private BigDecimal financialAmount;
}
