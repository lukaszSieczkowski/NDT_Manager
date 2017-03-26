package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.Document;
@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

}
