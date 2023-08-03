package ru.aston.documentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aston.documentservice.model.dto.DocumentDto;
import ru.aston.documentservice.model.dto.DocumentRequest;
import ru.aston.documentservice.service.DocumentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/document")
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/all")
    public List<DocumentDto> findAll() {
        return documentService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<DocumentDto> create(@RequestBody DocumentRequest documentRequest) {
        DocumentDto dto = documentService.save(documentRequest);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public DocumentDto findById(@PathVariable String id) {
        return documentService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        documentService.delete(id);
        return new ResponseEntity<>("Deleted with id { }" + id, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DocumentDto> update(@RequestBody DocumentRequest dto) {
        DocumentDto document = documentService.update(dto);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
}
