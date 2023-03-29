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
import java.util.Optional;

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
		User UserEntity = userService.findByEmail(user.getEmail()).get();
		return UserEntity;
	}


    @ApiOperation(value = "Search User by Id", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) { return userService.getUserById(id); }

	@ApiOperation(value = "Put User by Id", produces = "application/json")
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User user) { return userService.updateUser(id, user);	}
	@ApiOperation(value = "Delete User by Id", produces = "application/json")
	@DeleteMapping("/{id}")
	public Optional<Object> deleteUser(@PathVariable Long id) {
		return userService.deleteById2(id);
	}

}