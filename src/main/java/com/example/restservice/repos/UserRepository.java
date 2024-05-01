package com.example.restservice.repos;

import com.example.restservice.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username); // JPA will provide implementation for this query
}
