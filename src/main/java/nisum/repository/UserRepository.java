package nisum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import nisum.model.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : Proyecto Nisum
 * User: outrera
 * Email: orlandoutrera@gmail.com
 * Archictec : Orlando Utrera
 * Date: 14/10/22
 * Time: 06.07
 */
public interface UserRepository extends  PagingAndSortingRepository<User, Long> {
   @Query("SELECT u FROM User u WHERE u.email = ?1")
   User findByEmail2(String email);

	@Query("SELECT u FROM User u WHERE u.email = ?1 or u.name = ?1")
	User findByEmailOrUsername(String email);

	Optional<User> findByEmail(String email);


	Page<User> findAll(Pageable pageable);

}
