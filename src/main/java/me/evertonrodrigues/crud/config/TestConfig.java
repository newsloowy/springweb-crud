package me.evertonrodrigues.crud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import me.evertonrodrigues.crud.entities.User;
import me.evertonrodrigues.crud.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria Brown", "maria@email.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@email.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}

}
