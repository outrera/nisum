package nisum.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import nisum.model.entity.User;
import nisum.repository.UserRepository;
import nisum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : Proyecto Nisum
 * User: outrera
 * Email: orlandoutrera@gmail.com
 * Archictec : Orlando Utrera
 * Date: 14/10/22
 * Time: 08.05
 */
@Log4j2
@RestController
@RequestMapping("/api/users")
@Api(value = "A REST API application to manage User", description = "This API provides the capability to manage User", produces = "application/json")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;


	public UserController(UserService userService) {
	}


	@ApiOperation(value = "Get All Users", produces = "application/json")
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@ApiOperation(value = "Add New User", produces = "application/json")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody @Valid User user) {

		userService.createUser(user);
		User UserEntity = userRepository.findByEmail(user.getEmail()).get();
		return UserEntity;
	}


    @ApiOperation(value = "Search User by Id", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Put User by Id", produces = "application/json")
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
		return userRepository.findById(id)
				.map(x -> {
					x.setName(user.getName());
					x.setEmail(user.getEmail());
					return ResponseEntity.ok(userService.update(x));
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ApiOperation(value = "Delete User by Id", produces = "application/json")
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id) {
		return userRepository.findById(id)
				.map(user -> {
					userService.deleteById(id);
					return ResponseEntity.ok(user);
				})
				.orElseGet(() -> ResponseEntity.notFound().build());
	}



}