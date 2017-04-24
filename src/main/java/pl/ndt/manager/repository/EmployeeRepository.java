package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.Employee;
import pl.ndt.manager.model.User;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
