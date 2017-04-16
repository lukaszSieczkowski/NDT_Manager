package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.MeasuringEquipmentDTO;

import pl.ndt.manager.model.Location;
import pl.ndt.manager.model.MeasuringEquipment;

import pl.ndt.manager.repository.LocationRepository;
import pl.ndt.manager.repository.MeasuringEquipmentRepository;

import pl.ndt.manager.utils.DateConverter;

@Service
public class DeviceService {

	@Autowired
	private MeasuringEquipmentRepository measuringEquipmentRepository;
	@Autowired
	private LocationRepository locationRepository;

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
		System.out.println(devicesList);
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

}
