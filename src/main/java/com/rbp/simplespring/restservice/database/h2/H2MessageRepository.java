package com.rbp.simplespring.restservice.database.h2;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rbp.simplespring.restservice.database.h2.entity.MessageEntity;

public interface H2MessageRepository extends CrudRepository<MessageEntity, Long> {

	List<MessageEntity> findByMessageOwner(String owner);
}
