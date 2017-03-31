package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.ndt.manager.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	Employee findByEmail(String email);
}
