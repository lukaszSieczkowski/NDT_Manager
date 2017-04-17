package pl.ndt.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Verification;

public interface VerificationRepository extends CrudRepository<Verification, Long> {

	public List<Verification> findByMeasuringEquipment(MeasuringEquipment measuringEquipment);
}
