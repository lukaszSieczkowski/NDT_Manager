package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.JaegerTest;
@Repository
public interface JaegerTestRepository extends CrudRepository<JaegerTest, Long> {

}
