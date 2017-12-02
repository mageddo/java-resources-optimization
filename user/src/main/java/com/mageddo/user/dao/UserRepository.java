package com.mageddo.user.dao;

import com.mageddo.user.entity.UserEntity;

public interface UserRepository {
	UserEntity getById(int userId);
}
