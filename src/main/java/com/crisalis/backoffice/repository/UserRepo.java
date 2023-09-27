package com.crisalis.backoffice.repository;

import com.crisalis.backoffice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUsernameAndPassword(String username,String password);
}
