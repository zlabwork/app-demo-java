package com.zlabwork.genesis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.zlabwork.genesis.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT id, name, email, created_at FROM users WHERE name LIKE %?1%")
    Iterable<UserEntity> searchUserByName(String name);

}