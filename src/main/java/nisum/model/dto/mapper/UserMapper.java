package nisum.model.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import nisum.model.dto.PhoneRequest;
import nisum.model.dto.PhoneResponse;
import nisum.model.dto.UserRequest;
import nisum.model.dto.UserResponse;
import nisum.model.entity.Phone;
import nisum.model.entity.User;

@Data
public class UserMapper {
	
	
	public static User requestToEntity(UserRequest userRequest) {
		User user = new User();
		
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		
		List<Phone> phonesInUser = new ArrayList<>();
		if(!userRequest.getPhones().isEmpty()) {
			for(PhoneRequest phoneRequest : userRequest.getPhones() ) {
				Phone phone = new Phone ();
				phone.setNumber(phoneRequest.getNumber());
				phone.setContrycode(phoneRequest.getCountrycode());
				phone.setCitycode(phoneRequest.getCitycode());
				phonesInUser.add(phone);
			}
		}
	
		user.setPhones(phonesInUser);
		
		return user;
	}
		
	public static UserResponse entityToResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getName());
		userResponse.setEmail(user.getEmail());
		userResponse.setPassword(user.getPassword());
		userResponse.setCreated(user.getCreated());
		userResponse.setModifed(user.getModifed());
		userResponse.setLast_login(user.getLast_login());
		userResponse.setToken(user.getToken());
		userResponse.setIsactive(user.getIsactive());
				
		List<PhoneResponse> phonesInUserResponse = new ArrayList<>();
		if(!user.getPhones().isEmpty()) {
			for(Phone phoneFromUser : user.getPhones() ) {
				PhoneResponse phoneResponse = new PhoneResponse ();
				phoneResponse.setId(phoneFromUser.getId());
				phoneResponse.setNumber(phoneFromUser.getNumber());
				phoneResponse.setContrycode(phoneFromUser.getContrycode());
				phoneResponse.setCitycode(phoneFromUser.getCitycode());
				
				phonesInUserResponse.add(phoneResponse);
			}
		}
	
		userResponse.setPhones(phonesInUserResponse);
		
		
		return userResponse;
	}
	
	
	
}
