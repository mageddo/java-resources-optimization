package com.mageddo.conciliation.dao;


import com.mageddo.conciliation.entity.UserEntity;

import java.util.List;

public interface UserRepository {
	UserEntity getById(int userId);
	List<UserEntity> findAll();
}
