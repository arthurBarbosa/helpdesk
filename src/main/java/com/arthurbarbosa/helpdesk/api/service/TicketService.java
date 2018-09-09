package com.arthurbarbosa.helpdesk.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.arthurbarbosa.helpdesk.api.entity.ChangesStatus;
import com.arthurbarbosa.helpdesk.api.entity.Ticket;

@Component
public interface TicketService {

	Ticket createOrUpdate(Ticket ticket);

	Ticket findById(String id);

	void delete(String id);

	Page<Ticket> listTicket(int page, int count);

	ChangesStatus createChangeStatus(ChangesStatus changesStatus);

	Iterable<ChangesStatus> listChangeStatus(String ticketId);

	Page<Ticket> findByCurrentUser(int page, int count, String userId);

	Page<Ticket> findByParameters(int page, int count, String title, String status, String priority);

	Page<Ticket> findByParametersByAndCurrentUser(int page, int count, String title, String status, String priority,
			String userId);

	Page<Ticket> findByNumber(int page, int count, Integer number);

	Iterable<Ticket> findAll();

	public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status,
			String priority, String assignedUserId);

}
