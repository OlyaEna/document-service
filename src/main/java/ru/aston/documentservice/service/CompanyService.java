package ru.aston.documentservice.service;


import ru.aston.documentservice.model.dto.CompanyDto;
import ru.aston.documentservice.model.dto.CompanyRequest;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> findAll();
    CompanyDto save(CompanyRequest dto);

    void delete(String id);

    CompanyDto update(CompanyRequest dto);
    CompanyDto findById(String id);
}
