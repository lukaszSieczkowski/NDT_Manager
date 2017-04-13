package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.LocationDTO;
import pl.ndt.manager.model.Address;
import pl.ndt.manager.model.Location;
import pl.ndt.manager.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	List<LocationDTO> locations;

	/**
	 * Creates list of all Business Locations
	 * 
	 * @return Business Locations list
	 */
	public List<LocationDTO> getLocations() {
		List<Location> locationsList = (List<Location>) locationRepository.findAll();
		locations = new ArrayList<>();
		for (Location location : locationsList) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setId(location.getId());
			locationDTO.setInstitutionName(location.getInstitutionName());
			locationDTO.setStreet(location.getAddress().getStreet());
			locationDTO.setHouseNumber(String.valueOf(location.getAddress().getHouseNumber()));
			locationDTO.setLocalNumber(String.valueOf(location.getAddress().getLocalNumber()));
			locationDTO.setCity(location.getAddress().getCity());
			locationDTO.setZipCode(location.getAddress().getZipCode());
			locations.add(locationDTO);
		}

		return locations;

	}

	/**
	 * Saves Business Location in database
	 * 
	 * @param locationDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */

	public void saveLocation(LocationDTO locationDTO) {

		Location location = new Location();
		Address address = new Address();

		address.setStreet(locationDTO.getStreet());
		address.setHouseNumber(Integer.parseInt(locationDTO.getHouseNumber()));
		address.setLocalNumber(Integer.parseInt(locationDTO.getLocalNumber()));
		address.setCity(locationDTO.getCity());
		address.setZipCode(locationDTO.getZipCode());
		location.setId(locationDTO.getId());
		location.setInstitutionName(locationDTO.getInstitutionName());
		location.setAddress(address);

		locationRepository.save(location);
	}

}
