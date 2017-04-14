package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.TechnicalDocument;

public interface TechnicalDocumentRepository extends CrudRepository<TechnicalDocument, Long> {

}
