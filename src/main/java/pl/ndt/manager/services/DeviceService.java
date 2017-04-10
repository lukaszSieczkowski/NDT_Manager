package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.dto.MeasuringEquipmentDTO;
import pl.ndt.manager.model.Device;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Probe;
import pl.ndt.manager.repository.MeasuringEquipmentRepository;
import pl.ndt.manager.utils.DateConverter;
@Service
public class DeviceService {

	@Autowired
	private MeasuringEquipmentRepository measuringEquipmentRepository;
	
	private DateConverter dateConverter;
	private List<DeviceDTO> devices;
	
	public List<DeviceDTO> getMeasuringEqupiment(){
		devices= new ArrayList<>();
		dateConverter = new DateConverter();
		List<MeasuringEquipment> devicesList =  (List<MeasuringEquipment>) measuringEquipmentRepository.findAll();
		
		for(MeasuringEquipment equipment: devicesList){
			MeasuringEquipmentDTO equipmentDTO = new MeasuringEquipmentDTO();
			equipmentDTO.setId(equipment.getId());
			equipmentDTO.setDeviceCode(equipment.getDeviceCode());
			equipmentDTO.setName(equipment.getName());
			equipmentDTO.setProducer(equipment.getProducer());
			equipmentDTO.setProductionYear(equipment.getProductionYear());
			equipmentDTO.setModel(equipment.getModel());
			equipmentDTO.setSerialNumber(equipment.getSerialNumber());
			equipmentDTO.setStartOfUse(dateConverter.createDateToString(equipment.getStartOfUse()));
			devices.add(equipmentDTO);
		}
		
		return devices;
		
	}
}
