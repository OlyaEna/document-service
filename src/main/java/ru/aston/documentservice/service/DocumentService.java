package ru.aston.documentservice.service;

import ru.aston.documentservice.model.dto.DocumentDto;
import ru.aston.documentservice.model.dto.DocumentRequest;

import java.util.List;

public interface DocumentService {
    List<DocumentDto> findAll();

    DocumentDto save(DocumentRequest dto);

    void delete(String id);

    DocumentDto update(DocumentRequest dto);

    DocumentDto findById(String id);
}
