package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;


import pl.ndt.manager.model.Report;

public interface ReportsRepository extends CrudRepository<Report, Long> {

}
