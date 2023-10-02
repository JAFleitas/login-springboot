package com.crisalis.backoffice.repository;

import com.crisalis.backoffice.model.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends CrudRepository<OrderDetail,Long> {
}
