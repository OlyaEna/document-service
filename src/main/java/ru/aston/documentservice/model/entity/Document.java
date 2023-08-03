package ru.aston.documentservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Getter
@Setter
@org.springframework.data.mongodb.core.mapping.Document
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    private String id;
    private Company company;
    private String bankDetails;
    private LocalDateTime createdAt;
}