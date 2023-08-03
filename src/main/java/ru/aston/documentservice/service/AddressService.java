package ru.aston.documentservice.service;

import ru.aston.documentservice.model.dto.AddressDto;

import java.util.List;

public interface AddressService{

    List<AddressDto> findAll();
    AddressDto save(AddressDto addressDto);

    void delete(String id);

    AddressDto update(AddressDto addressDto);
    AddressDto findById(String id);
}
