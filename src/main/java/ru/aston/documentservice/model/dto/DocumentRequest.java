package ru.aston.documentservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DocumentRequest {
    private String id;
    private String companyId;
    private String bankDetails;
    private LocalDateTime createdAt;
}
