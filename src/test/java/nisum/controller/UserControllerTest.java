package nisum.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import nisum.exception.PasswordValidationException;
import nisum.model.dto.UserRequest;
import nisum.model.entity.User;
import nisum.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	UserController userController;
	
	@Mock
	UserService userService;
	
		
	@BeforeEach
	void setUp() throws Exception {
		userController = new UserController(userService);
	}

	@Test
	void testAddUser() {
		UserRequest userRequestMock = new UserRequest();
		userRequestMock.setName("outrera");
		
		User userMock = new User();
		userMock.setName("outrera");
		userMock.setPassword("");
		
		userService.createUser(userMock);

	}

}
