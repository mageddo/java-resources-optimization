package com.mageddo.user.dao;


import com.mageddo.user.entity.UserEntity;

import java.util.List;

public interface UserRepository {
	UserEntity getById(int userId);
	List<UserEntity> findAll();
}
