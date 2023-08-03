package ru.aston.documentservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.documentservice.model.dto.CompanyDto;
import ru.aston.documentservice.model.dto.CompanyRequest;
import ru.aston.documentservice.model.repository.CompanyRepository;
import ru.aston.documentservice.service.AddressService;
import ru.aston.documentservice.service.CompanyService;
import ru.aston.documentservice.service.mapper.CompanyMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final AddressService addressService;


    @Override
    public List<CompanyDto> findAll() {
        return companyMapper.listToDto(companyRepository.findAll());
    }

    @Override
    public CompanyDto save(CompanyRequest dto) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setPersonnel(dto.getPersonnel());
        companyDto.setOccupation(dto.getOccupation());
        companyDto.setFormOwnership(dto.getFormOwnership());
        companyDto.setFinancialAmount(dto.getFinancialAmount());
        companyDto.setAddress(addressService.findById(dto.getAddressId()));
        return create(companyDto);
    }

    private CompanyDto create(CompanyDto dto) {
        return companyMapper.toDto(companyRepository.save(companyMapper.toEntity(dto)));
    }
    @Override
    public void delete(String id){
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyDto update(CompanyRequest dto) {
        CompanyDto companyDto = findById(dto.getId());
        if(companyDto != null){
            companyDto.setPersonnel(dto.getPersonnel());
            companyDto.setOccupation(dto.getOccupation());
            companyDto.setFormOwnership(dto.getFormOwnership());
            companyDto.setFinancialAmount(dto.getFinancialAmount());
            companyDto.setAddress(addressService.findById(dto.getAddressId()));
            create(companyDto);
        }
        return companyDto;
    }

    @Override
    public CompanyDto findById(String id) {
        return companyMapper.toDto(companyRepository.getById(id));
    }
}
