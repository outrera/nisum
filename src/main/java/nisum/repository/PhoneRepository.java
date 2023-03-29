package nisum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nisum.model.entity.Phone;

@Repository
public interface PhoneRepository extends CrudRepository <Phone, Long>  {

}
