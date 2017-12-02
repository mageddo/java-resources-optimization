package com.mageddo.user.dao;

import com.mageddo.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserEntity getById(int userId) {
		return entityManager.find(UserEntity.class, userId);
	}
}
