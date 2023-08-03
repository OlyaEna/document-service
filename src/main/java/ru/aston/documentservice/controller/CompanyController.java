package ru.aston.documentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.documentservice.model.dto.CompanyDto;
import ru.aston.documentservice.model.dto.CompanyRequest;
import ru.aston.documentservice.service.CompanyService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/all")
    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }

    @PostMapping("/create")
        public ResponseEntity<CompanyDto> create(@RequestBody CompanyRequest companyRequest) {
        CompanyDto dto = companyService.save(companyRequest);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CompanyDto findById(@PathVariable String id) {
        return companyService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        companyService.delete(id);
        return new ResponseEntity<>("Deleted with id { }" + id, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CompanyDto> update(@RequestBody CompanyRequest dto) {
        CompanyDto company = companyService.update(dto);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
