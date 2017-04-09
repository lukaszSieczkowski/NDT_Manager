package pl.ndt.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.NdtCertificate;
@Repository
public interface NdtCertificateRepository extends CrudRepository<NdtCertificate, Long> {

}
