package nisum.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nisum.exception.PhoneNotFoundException;
import nisum.model.entity.Phone;
import nisum.repository.PhoneRepository;

@Service
public class PhoneService {

	private final PhoneRepository phoneRepository;
	
	@Autowired
	public PhoneService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	
	public Phone addPhone(Phone phone) {
		return phoneRepository.save(phone);
	}
	
	public List<Phone> getPhones(){
		return StreamSupport
                .stream(phoneRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	public Phone getPhone(Long id){
        return phoneRepository.findById(id).orElseThrow(() ->
                new PhoneNotFoundException(id));
    }
	
	public Phone deletePhone(Long id){
        Phone phone = getPhone(id);
        phoneRepository.delete(phone);
        return phone;
    }
	
	@Transactional
    public Phone editPhone(Long id, Phone phone){
        Phone phoneToEdit = getPhone(id);
        phoneToEdit.setNumber(phone.getNumber());
        phoneToEdit.setContrycode(phone.getContrycode());
        phoneToEdit.setCitycode(phone.getCitycode());  
        return phoneToEdit;
    }
}
