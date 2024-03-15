package com.Matheusgabriel1234.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Matheusgabriel1234.workshop.domain.Post;
import com.Matheusgabriel1234.workshop.domain.Users;
import com.Matheusgabriel1234.workshop.repository.PostRepository;
import com.Matheusgabriel1234.workshop.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  
	
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		// TODO Auto-generated method stub
		postRepo.deleteAll();
		repo.deleteAll();
		Users eduarda = new Users(null,"Eduarda Cecato","eduarda@gmail.com");
		Users luiza = new Users(null,"Luiza Grando","luiza@gmail.com");
		Users everton = new Users(null,"Everton Cecato","everton@gmail.com");
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para SC abraços",luiza);
		Post post2 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para o RJ abraços",eduarda);
		repo.saveAll(Arrays.asList(eduarda,luiza,everton));
		postRepo.saveAll(Arrays.asList(post1,post2));
	}
	

}
