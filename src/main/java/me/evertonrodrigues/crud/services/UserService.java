package me.evertonrodrigues.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.evertonrodrigues.crud.entities.User;
import me.evertonrodrigues.crud.exceptions.ResourceNotFoundException;
import me.evertonrodrigues.crud.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		try {			
			userRepository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public User update(Long id, User user) {
		try {
			User registry = userRepository.getReferenceById(id);
			updateData(registry, user);
			return userRepository.save(registry);
		} catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User registry, User user) {
		registry.setName(user.getName());
		registry.setEmail(user.getEmail());
		registry.setPhone(user.getPhone());
	}
}
