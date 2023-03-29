package nisum.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private Date modifed;
	private Date last_login;
	private String token;
	private Boolean isactive;
	private List<PhoneResponse> phones = new ArrayList<>();
	
	
}
