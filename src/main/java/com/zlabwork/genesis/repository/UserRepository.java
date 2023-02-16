package com.zlabwork.genesis.repository;

import org.springframework.data.repository.CrudRepository;
import com.zlabwork.genesis.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}