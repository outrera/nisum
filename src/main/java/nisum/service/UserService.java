package nisum.service;


import java.util.*;

import nisum.utils.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nisum.exception.GenericException;
import nisum.exception.PasswordValidationException;
import nisum.model.entity.User;
import nisum.repository.UserRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : Proyecto Nisum
 * User: outrera
 * Email: orlandoutrera@gmail.com
 * Archictec : Orlando Utrera
 * Date: 14/10/22
 * Time: 06.09
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Environment env;

	public void createUser(User user) {
		String regexEmail = env.getProperty("regex.email");
		String regexPass = env.getProperty("regex.password");

		String email = user.getEmail();
		String password = user.getPassword();



		if (!Validations.emailIsValid(email,regexEmail)){
			throw new GenericException("User with email " + user.getEmail() + " is not valid");
		}

		if (!Validations.passwordIsValid(password,regexPass)){
			throw new GenericException("User with password " + user.getPassword() + " is not valid");
		}


		Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new GenericException("User with email " + user.getEmail() + " already exists");
		}


		user.setIsactive(Boolean.TRUE);
		user.setLast_login(new Date());

		try {
			userRepository.save(user);
		}catch(DataIntegrityViolationException e){
			throw new PasswordValidationException("Email is already assigned");
		}catch(Exception e) {
			throw new GenericException("Internal error, please communicate with the administrator of this application");
		}

	}

	public Iterable<User> listAll() {
		return userRepository.findAll();
	}



	public void save(User user) {
		userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}


	public List<User> getAllUsers() {
		return new ArrayList<>((Collection) userRepository.findAll());
	}


	public Optional<Object> deleteById2(Long id) {
		return Optional.of(userRepository.findById(id)
				.map(user -> {
					userRepository.deleteById(id);
					return ResponseEntity.ok(user);
				})
				.orElseGet(() -> ResponseEntity.notFound().build()));
	}

	public ResponseEntity<User> updateUser(Long id, User user) 	{
		return userRepository.findById(id)
				.map(x -> {
					x.setName(user.getName());
					x.setEmail(user.getEmail());
					return ResponseEntity.ok(userRepository.save(x));
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	public Optional<User> findByEmail(String email)  {
		return userRepository.findByEmail(email);
	}

	public ResponseEntity<User> getUserById(Long id) {
		return userRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}



