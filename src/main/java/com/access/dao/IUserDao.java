package com.access.dao;

import com.access.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    List<UserEntity> findAllUsers();
}
