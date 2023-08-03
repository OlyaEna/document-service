package ru.aston.documentservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.aston.documentservice.model.entity.FormOwnership;

import java.math.BigDecimal;

@Getter
@Setter
public class CompanyRequest {
    private String id;
    private FormOwnership formOwnership;
    private String addressId;
    private String occupation;
    private Long personnel;
    private BigDecimal financialAmount;
}
