package ru.aston.documentservice.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.aston.documentservice.model.entity.Address;
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
    Address findAddressById(String id);
}
