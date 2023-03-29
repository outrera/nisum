package nisum.model.dto;

import lombok.Data;

@Data
public class PhoneResponse {

	private Long id;	
	private String number;
	private Integer citycode;
	private Integer contrycode;
	
	
}
