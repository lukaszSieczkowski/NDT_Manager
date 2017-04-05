package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import pl.ndt.manager.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
