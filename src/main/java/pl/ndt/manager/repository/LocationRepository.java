package pl.ndt.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.ndt.manager.model.Location;
@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

	Location getByInstitutionName(String institutionName);

}
