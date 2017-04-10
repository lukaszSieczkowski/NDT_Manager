package pl.ndt.manager.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.components.DevicesList;
import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.services.DeviceService;


@Controller
public class DeviceControler {
	
	
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DevicesList devicesList;
	
	@RequestMapping("/showMeasuringDevices")
	public String showAllDevices(Model model){
		devicesList.setDevices(deviceService.getMeasuringEqupiment());
		model.addAttribute("devices",devicesList);
		return "devices/show_devices/showMeasuringDevices";
		
	}

}
