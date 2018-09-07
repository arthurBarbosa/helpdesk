package com.arthurbarbosa.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arthurbarbosa.helpdesk.api.entity.ChangesStatus;

public interface ChangesStatusRepository extends MongoRepository<ChangesStatus, String>{
	
	Iterable<ChangesStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}
