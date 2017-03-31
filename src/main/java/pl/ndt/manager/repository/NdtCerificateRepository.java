package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.NdtCertificate;

public interface NdtCerificateRepository extends CrudRepository<NdtCertificate, Long> {

}
