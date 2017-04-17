package pl.ndt.manager.components;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import pl.ndt.manager.dto.DeviceDTO;
import pl.ndt.manager.model.Device;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DevicesList {

	
	private List<DeviceDTO> devices;
	private DeviceDTO device;
	
	public DevicesList (List<DeviceDTO> devices,DeviceDTO deviceDTO){
		this.devices=devices;
		this.device = device;
	}

	public List<DeviceDTO> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceDTO> devices) {
		this.devices = devices;
	}

	public DeviceDTO getDevice() {
		return device;
	}

	public void setDevice(DeviceDTO device) {
		this.device = device;
	}
	
	
	
}
