package ru.aston.documentservice.service.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import ru.aston.documentservice.model.dto.AddressDto;
import ru.aston.documentservice.model.entity.Address;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AddressMapper {
    private ModelMapper modelMapper;

    public Address toEntity(AddressDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Address.class);
    }

    public AddressDto toDto(Address entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, AddressDto.class);
    }

    public List<AddressDto> listToDto(List<Address> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<AddressDto>>() {
        }.getType());
    }

}
