package pl.ndt.manager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Report;

public interface MeasuringEquipmentRepository extends CrudRepository<MeasuringEquipment, Long> {

public List<MeasuringEquipment> findByReport(Report report);
}
