package pl.ndt.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.Customer;
import pl.ndt.manager.model.Report;

public interface ReportsRepository extends CrudRepository<Report, Long> {
	
	public List<Report> findByCustomer(Customer customer);
	public Report findByReportNumber(String reportNumber);
}
