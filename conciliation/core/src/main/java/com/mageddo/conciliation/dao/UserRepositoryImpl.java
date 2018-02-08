package com.mageddo.conciliation.dao;

import com.mageddo.conciliation.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserEntity getById(int userId) {
		return entityManager.find(UserEntity.class, userId);
	}

	@Transactional
	@Override
	public List<UserEntity> findAll() {
		return entityManager.createQuery("FROM USER").getResultList();
	}
}
