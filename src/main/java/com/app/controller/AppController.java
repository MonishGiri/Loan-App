package com.app.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
//import reactDom from 'react-dom';
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Client;
import com.app.model.User;
import com.app.respository.ClientRepo;
import com.app.respository.UserRepository;
import com.app.service.ClientService;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ClientRepo clientRepo;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setType("user"); 
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		List<Client> listClient = clientRepo.findAll();
		model.addAttribute("listClient", listClient);
		
		return "users";
	}
	@GetMapping("/loan_application")
	public String loanApplication() {
		return "loan_application";
	}
	
	@PostMapping("/process_loan_application")
	public String clientloanApplication(@ModelAttribute Client client,Model model, @RequestParam MultipartFile img) {
		System.out.println(client);
		System.out.println(img.getOriginalFilename());
		client.setImage(img.getOriginalFilename());
		
		if(img.getOriginalFilename() != null) {
			try {
				File saveFile = new ClassPathResource("static/img/").getFile();  
				
				Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
				
				System.out.println(path);
				
				Files.copy(img.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
				
				System.out.println("Image uploaded Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(client.getAnnualIncome() >= 600000) {
			client.setCredit(5);
		}
		else if(client.getAnnualIncome() >= 400000) {
			client.setCredit(4);
		}
		else if(client.getAnnualIncome() >= 250000) {
			client.setAnnualIncome(3);
		}
		else if(client.getAnnualIncome() >= 200000) {
			client.setCredit(2);
		}
		else if(client.getAnnualIncome() >= 150000) {
			client.setCredit(1);
		}
		clientService.addClient(client);
		model.addAttribute(client);
		return "application_success";
	}
	
	@GetMapping("users/approve")
	public String approve(@RequestParam("id") long id) {
		Client clientid = clientRepo.findById(id);
		clientid.setStatus("Approved");
		
		System.out.println(clientid.getStatus());
		
		clientService.updateClient(clientid);
		return "redirect:/users";
	}
	
	@GetMapping("users/reject")
	public String reject(@RequestParam("id") long id) {
		Client clientid = clientRepo.findById(id);
		clientid.setStatus("Rejected");
		
		System.out.println(clientid.getStatus());
		clientService.updateClient(clientid);
		return "redirect:/users";
	}
	
}
