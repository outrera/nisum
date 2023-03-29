package nisum.model.dto;

import lombok.Data;

@Data
public class PhoneRequest {

	private String number;
	private Integer citycode;
	private Integer countrycode;
	
	
}
