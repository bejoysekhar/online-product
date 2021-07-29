package com.product.onlineproduct.repository;

import com.product.onlineproduct.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("Select u from User u")
    List<User> getAllUsers();
}
