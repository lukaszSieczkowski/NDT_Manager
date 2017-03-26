package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.Employee;

@Repository
public interface UserRepository extends CrudRepository<Employee, Long>{
	Employee findByEmail(String email);
}
