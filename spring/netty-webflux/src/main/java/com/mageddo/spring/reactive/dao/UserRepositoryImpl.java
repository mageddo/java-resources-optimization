package com.mageddo.spring.reactive.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mageddo.spring.reactive.entity.UserEntity;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Mono<UserEntity> getById(int userId) {
		return Mono.justOrEmpty(entityManager.find(UserEntity.class, userId));
	}
}
