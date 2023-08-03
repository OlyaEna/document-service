package ru.aston.documentservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.documentservice.model.dto.AddressDto;
import ru.aston.documentservice.model.repository.AddressRepository;
import ru.aston.documentservice.service.AddressService;
import ru.aston.documentservice.service.mapper.AddressMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    @Override
    public List<AddressDto> findAll() {
        return addressMapper.listToDto(addressRepository.findAll());
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        return addressMapper.toDto(addressRepository.save(addressMapper.toEntity(addressDto)));
    }

    @Override
    public void delete(String id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        AddressDto address = findById(addressDto.getId());
        if(address != null){
            address.setCountry(addressDto.getCountry());
            address.setCity(addressDto.getCity());
            address.setStreetName(addressDto.getStreetName());
            address.setStreetNumber(addressDto.getStreetNumber());
            address.setPostCode(addressDto.getPostCode());
            save(address);
        }
        return address;
    }

    @Override
    public AddressDto findById(String id){
        return addressMapper.toDto(addressRepository.findAddressById(id));
    }

}
