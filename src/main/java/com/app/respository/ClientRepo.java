package com.app.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Client;
import com.app.model.User;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer>{
	@Query("SELECT c FROM Client c WHERE c.id = ?1")
	public Client findById(long id);
}
