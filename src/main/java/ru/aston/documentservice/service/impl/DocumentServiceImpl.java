package ru.aston.documentservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.documentservice.model.dto.DocumentDto;
import ru.aston.documentservice.model.dto.DocumentRequest;
import ru.aston.documentservice.model.repository.DocumentRepository;
import ru.aston.documentservice.service.CompanyService;
import ru.aston.documentservice.service.DocumentService;
import ru.aston.documentservice.service.mapper.DocumentMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final CompanyService companyService;

    @Override
    public List<DocumentDto> findAll() {
        return documentMapper.listToDto(documentRepository.findAll());
    }

    @Override
    public DocumentDto save(DocumentRequest dto) {
        DocumentDto documentDto = new DocumentDto();
        documentDto.setCompany(companyService.findById(dto.getCompanyId()));
        documentDto.setCreatedAt(LocalDateTime.now());
        documentDto.setBankDetails(dto.getBankDetails());
        return create(documentDto);
    }

    private DocumentDto create(DocumentDto dto) {
        return documentMapper.toDto(documentRepository.save(documentMapper.toEntity(dto)));
    }

    @Override
    public void delete(String id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentDto update(DocumentRequest dto) {
        DocumentDto documentDto = findById(dto.getId());
        if (documentDto != null) {
            documentDto.setCompany(companyService.findById(dto.getCompanyId()));
            documentDto.setBankDetails(dto.getBankDetails());
            create(documentDto);
        }
        return documentDto;
    }

    @Override
    public DocumentDto findById(String id) {
        return documentMapper.toDto(documentRepository.getById(id));
    }
}
