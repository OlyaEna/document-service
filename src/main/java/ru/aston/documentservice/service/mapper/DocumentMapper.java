package ru.aston.documentservice.service.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import ru.aston.documentservice.model.dto.DocumentDto;
import ru.aston.documentservice.model.entity.Document;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class DocumentMapper {
    private ModelMapper modelMapper;

    public Document toEntity(DocumentDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Document.class);
    }

    public DocumentDto toDto(Document entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, DocumentDto.class);
    }

    public List<DocumentDto> listToDto(List<Document> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<DocumentDto>>() {
        }.getType());
    }

}
