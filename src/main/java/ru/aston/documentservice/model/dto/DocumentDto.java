package ru.aston.documentservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DocumentDto {
    private String id;
    private CompanyDto company;
    private String bankDetails;
    private LocalDateTime createdAt;
}
