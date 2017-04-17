package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.Probe;

public interface ProbeRepository extends CrudRepository<Probe, Long> {

}
