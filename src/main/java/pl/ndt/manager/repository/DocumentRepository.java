package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.ndt.manager.model.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

}
