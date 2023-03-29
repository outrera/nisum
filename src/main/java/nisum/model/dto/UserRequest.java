package nisum.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserRequest {
	
	private String name;
	private String email;
	private String password;
	private List<PhoneRequest> phones = new ArrayList<>();
	
	
}
