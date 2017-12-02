package com.mageddo.spring.reactive.dao;

import com.mageddo.spring.reactive.entity.UserEntity;
import reactor.core.publisher.Mono;

public interface UserRepository {
	Mono<UserEntity> getById(int userId);
}
