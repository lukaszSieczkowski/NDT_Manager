package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
