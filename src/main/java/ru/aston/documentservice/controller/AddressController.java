package ru.aston.documentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.documentservice.model.dto.AddressDto;
import ru.aston.documentservice.service.AddressService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/all")
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable String id) {
        return addressService.findById(id);
    }


    @PostMapping("/create")
    public ResponseEntity<AddressDto> create(@RequestBody AddressDto addressDto) {
        AddressDto address = addressService.save(addressDto);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        addressService.delete(id);
        return new ResponseEntity<>("Deleted with id {}" + id, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AddressDto> update(@RequestBody AddressDto addressDto) {
        AddressDto address = addressService.update(addressDto);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping()
    public String hello(){
        return "Hello!";
    }
}
