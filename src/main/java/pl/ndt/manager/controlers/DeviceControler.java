package pl.ndt.manager.controlers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.ndt.manager.components.DevicesList;
import pl.ndt.manager.components.EmployeeList;
import pl.ndt.manager.components.LocationsList;
import pl.ndt.manager.dto.DeviceDTO;

import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.dto.MeasuringEquipmentDTO;

import pl.ndt.manager.services.DeviceService;
import pl.ndt.manager.services.EmployeeService;
import pl.ndt.manager.services.LocationService;

@Controller
@SessionAttributes({ "employess", "locations" })
public class DeviceControler {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private DevicesList devicesList;
	@Autowired
	private LocationsList locationsList;

	
	/**
	 * Shows list of Measuring Devices
	 * 
	 * @param model
	 *            Holder for attributes
	 * @return showMeasuringEquipment view
	 */
	@RequestMapping("/showMeasuringDevices")
	public String showAllDevices(Model model) {
		
		List<DeviceDTO> devices = deviceService.getMeasuringEqupiment();
		devicesList.setDevices(devices);
		model.addAttribute("devices", devicesList);
		
		return "devices/show_devices/showMeasuringEquipment";
	}

	/**
	 * Shows form to save Measuring Device in system
	 * 
	 * @param model
	 *            Holed for attributes
	 * 
	 * @return addMeasuringEquipment view
	 */
	@RequestMapping("/adddMeasuringDevice")
	public String addDevice(Model model) {
		
		List<LocationDTO> locationsDTO = locationService.getLocations();
		locationsList.setLocations(locationsDTO);
		model.addAttribute("locations", locationsList);
		model.addAttribute("measuringEquipmentDTO", new MeasuringEquipmentDTO());
		
		return "devices/add_device/addMeasuringEquipment";
	}

	/**
	 * Saves new Measuring Device in System
	 * 
	 * @param measuringEquipmentDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 * @param model
	 *            Holder for attributes
	 * @return addMeasuringEquipmen view
	 */
	@RequestMapping("/saveMeasuringDevice")
	public String addVerification(@Valid @ModelAttribute MeasuringEquipmentDTO measuringEquipmentDTO,
			BindingResult result, Model model) {
		
		if (!result.hasErrors()) {
			deviceService.saveDevice(measuringEquipmentDTO);
		}

		return "devices/add_device/addMeasuringEquipment";
	}

}
