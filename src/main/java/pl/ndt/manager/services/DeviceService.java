package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.components.DevicesList;
import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.MeasuringEquipmentDTO;
import pl.ndt.manager.dto.ProbeDTO;
import pl.ndt.manager.model.Device;
import pl.ndt.manager.model.Location;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Probe;
import pl.ndt.manager.model.enums.TypeOfTesting;
import pl.ndt.manager.repository.LocationRepository;
import pl.ndt.manager.repository.MeasuringEquipmentRepository;
import pl.ndt.manager.repository.ProbeRepository;
import pl.ndt.manager.utils.DateConverter;

@Service
public class DeviceService {

	@Autowired
	private MeasuringEquipmentRepository measuringEquipmentRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private ProbeRepository probeRepository;
	@Autowired
	private DevicesList devicesList;

	private DateConverter dateConverter;
	private List<DeviceDTO> devices;

	/**
	 * Creates list of all Measuring Devices
	 * 
	 * @return
	 */

	public List<DeviceDTO> getMeasuringEqupiment() {
		devices = new ArrayList<>();
		dateConverter = new DateConverter();
		List<MeasuringEquipment> devicesList = (List<MeasuringEquipment>) measuringEquipmentRepository.findAll();

		for (MeasuringEquipment equipment : devicesList) {
			MeasuringEquipmentDTO equipmentDTO = new MeasuringEquipmentDTO();
			equipmentDTO.setId(equipment.getId());
			equipmentDTO.setDeviceCode(equipment.getDeviceCode());
			equipmentDTO.setName(equipment.getName());
			equipmentDTO.setProducer(equipment.getProducer());
			equipmentDTO.setProductionYear(String.valueOf(equipment.getProductionYear()));
			equipmentDTO.setModel(equipment.getModel());
			equipmentDTO.setSerialNumber(equipment.getSerialNumber());
			equipmentDTO.setStartOfUse(dateConverter.createDateToString(equipment.getStartOfUse()));
			equipmentDTO.setLocationName(equipment.getLocation().getInstitutionName());
			equipmentDTO.setTypeOfTesting(equipment.getTypeOfTesting());

			devices.add(equipmentDTO);
		}

		return devices;

	}

	/**
	 * Saves Measuring Devices in database
	 * 
	 * @param mesuringDeviceDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */

	public void saveDevice(MeasuringEquipmentDTO measuringEquipmentDTO) {

		DateConverter dateConverter = new DateConverter();

		String institutionName = measuringEquipmentDTO.getLocationName();
		Location location = locationRepository.getByInstitutionName(institutionName);

		MeasuringEquipment measuringEquipment = new MeasuringEquipment();
		measuringEquipment.setId(measuringEquipmentDTO.getId());
		measuringEquipment.setDeviceCode(measuringEquipmentDTO.getDeviceCode());
		measuringEquipment.setLocation(location);
		measuringEquipment.setModel(measuringEquipmentDTO.getModel());
		measuringEquipment.setName(measuringEquipmentDTO.getName());
		measuringEquipment.setProducer(measuringEquipmentDTO.getProducer());
		measuringEquipment.setProductionYear(Integer.parseInt(measuringEquipmentDTO.getProductionYear()));
		measuringEquipment.setSerialNumber(measuringEquipmentDTO.getSerialNumber());
		measuringEquipment
				.setStartOfUse(dateConverter.createDateFromString(measuringEquipmentDTO.getStartOfUse(), 0, 0));
		measuringEquipment.setTypeOfTesting(measuringEquipmentDTO.getTypeOfTesting());
		measuringEquipment.setFerquencyOfVerification(measuringEquipmentDTO.getValidityPeriod());

		measuringEquipmentRepository.save(measuringEquipment);

	}

	/**
	 * Creates list of all Probes
	 * 
	 * @return
	 */

	public List<DeviceDTO> getProbes() {
		devices = new ArrayList<>();
		dateConverter = new DateConverter();
		List<Probe> probesList = (List<Probe>) probeRepository.findAll();

		for (Probe probe : probesList) {
			ProbeDTO probeDTO = new ProbeDTO();
			probeDTO.setId(probe.getId());
			probeDTO.setName(probe.getName());
			probeDTO.setProducer(probe.getProducer());
			probeDTO.setProductionYear(String.valueOf(probe.getProductionYear()));
			probeDTO.setModel(probe.getModel());
			probeDTO.setSerialNumber(probe.getSerialNumber());
			probeDTO.setStartOfUse(dateConverter.createDateToString(probe.getStartOfUse()));
			probeDTO.setLocationName(probe.getLocation().getInstitutionName());
			probeDTO.setTypeOfTesting(probe.getTypeOfTesting());
			probeDTO.setAngle(String.valueOf(probe.getAngle()));
			probeDTO.setFrequency(String.valueOf(probe.getFrequency()));
			devices.add(probeDTO);
		}
		return devices;
	}

	/**
	 * Saves Probe in database
	 * 
	 * @param probeDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */

	public void saveProbe(ProbeDTO probeDTO) {

		DateConverter dateConverter = new DateConverter();

		String institutionName = probeDTO.getLocationName();
		Location location = locationRepository.getByInstitutionName(institutionName);

		Probe probe = new Probe();
		probe.setId(probeDTO.getId());
		probe.setLocation(location);
		probe.setModel(probeDTO.getModel());
		probe.setName(probeDTO.getName());
		probe.setProducer(probeDTO.getProducer());
		probe.setProductionYear(Integer.parseInt(probeDTO.getProductionYear()));
		probe.setSerialNumber(probeDTO.getSerialNumber());
		probe.setStartOfUse(dateConverter.createDateFromString(probeDTO.getStartOfUse(), 0, 0));
		probe.setTypeOfTesting(probeDTO.getTypeOfTesting());
		probe.setAngle(Integer.parseInt(probeDTO.getAngle()));
		probe.setFrequency(Double.parseDouble(probeDTO.getFrequency()));

		System.out.println(probe);

		probeRepository.save(probe);

	}

	/**
	 * Sorts measuring Devices by Type of Testing
	 * 
	 * @param typeOfTesting
	 */
	public void sortDeviceByMethood(TypeOfTesting typeOfTesting) {
		List<DeviceDTO> equipmet = devicesList.getDevices();
		equipmet = equipmet.stream().filter(a -> a.getTypeOfTesting().equals(typeOfTesting))
				.collect(Collectors.toList());
		devicesList.setDevices(equipmet);
	}

}
