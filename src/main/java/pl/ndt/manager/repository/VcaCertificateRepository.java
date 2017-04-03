package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.VcaCertificate;

@Repository
public interface VcaCertificateRepository extends CrudRepository<VcaCertificate, Long> {

}
