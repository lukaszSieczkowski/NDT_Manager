package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.Verification;

public interface VerificationRepository extends CrudRepository<Verification, Long> {

}
