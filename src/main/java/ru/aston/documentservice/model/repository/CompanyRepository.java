package ru.aston.documentservice.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aston.documentservice.model.entity.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
    @Query("{id :?0}")
    Company getById(String id);
}
