package ru.aston.documentservice.service.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import ru.aston.documentservice.model.dto.CompanyDto;
import ru.aston.documentservice.model.entity.Company;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class CompanyMapper {
    private ModelMapper modelMapper;

    public Company toEntity(CompanyDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Company.class);
    }

    public CompanyDto toDto(Company entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CompanyDto.class);
    }

    public List<CompanyDto> listToDto(List<Company> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<CompanyDto>>() {
        }.getType());
    }

}
