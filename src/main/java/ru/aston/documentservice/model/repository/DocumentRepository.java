package ru.aston.documentservice.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aston.documentservice.model.entity.Document;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    @Query("{id :?0}")
    Document getById(String id);
}
