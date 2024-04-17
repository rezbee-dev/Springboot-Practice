package com.example.restservice.repos;

import com.example.restservice.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

// Since taco objects don't exist outside of orders, we don't create a TacoRepository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    // Custom queries can be done with JPA Named Queries, JPQL, or Native Queries (@Query)
}
