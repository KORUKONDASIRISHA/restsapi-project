package com.example.demo.repository;
import com.example.demo.models.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface users_repo extends CrudRepository<user, Integer> {

}

