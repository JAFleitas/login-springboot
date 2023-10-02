package com.crisalis.backoffice.repository;

import com.crisalis.backoffice.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
