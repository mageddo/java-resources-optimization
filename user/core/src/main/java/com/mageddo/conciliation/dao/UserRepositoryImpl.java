package com.mageddo.conciliation.dao;

import com.mageddo.conciliation.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserEntity getById(int userId) {
		return entityManager.find(UserEntity.class, userId);
	}

	@Override
	public List<UserEntity> findAll() {
		return entityManager.createQuery("FROM USER").getResultList();
	}
}
