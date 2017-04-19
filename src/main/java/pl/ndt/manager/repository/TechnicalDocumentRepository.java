package pl.ndt.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import pl.ndt.manager.model.Report;
import pl.ndt.manager.model.TechnicalDocument;

public interface TechnicalDocumentRepository extends CrudRepository<TechnicalDocument, Long> {
	public List<TechnicalDocument>findByReport(Report report);
}
