package com.app.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Client;
import com.app.respository.ClientRepo;

@Service
public class ClientService {
	
	public static String generateAppNo() {
		Random random = new Random();
		String otp= new DecimalFormat("00000000").format(new Random().nextInt(99999999));
		int randomNum = random.nextInt(5000); 
		String app_No = "LOANAPP"+otp+Integer.toString(randomNum) ;
		return app_No;
	}
	
	@Autowired
	private ClientRepo repo;
	public void addClient(Client client) {
		client.setApplicationNumber(generateAppNo());
		repo.save(client);
	}
	
	public void updateClient(Client client) {
		repo.save(client);
	}
	
	
}
