package pl.ndt.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.Report;
import pl.ndt.manager.model.ResultsOfExamination;

public interface ResultOfExaminationRepository extends CrudRepository<ResultsOfExamination, Long>{

	public List<ResultsOfExamination> findByReport(Report report);
}
