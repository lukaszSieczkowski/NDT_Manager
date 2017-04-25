package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pl.ndt.manager.dto.MeasuringEquipmentDTO;
import pl.ndt.manager.model.Chemical;
import pl.ndt.manager.model.Location;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.enums.ChemicalType;
import pl.ndt.manager.model.enums.TypeOfTesting;
import pl.ndt.manager.repository.ChemicalsRepository;
import pl.ndt.manager.utils.DateConverter;
@Service
public class ChemicalsService {

	@Autowired
	private ChemicalsRepository chemicalsRepository;
	
	List<Chemical> chemicals;

	/**
	 * Creates list of all Chemicals
	 * 
	 * @return
	 */
	
	public List<Chemical> getChemicals() {
		chemicals = new ArrayList<>();

		List<Chemical> chemicalsList = (List<Chemical>) chemicalsRepository.findAll();
		return chemicalsList;
	}

	public void saveChemical(Chemical chemical) {
	
		
		chemicalsRepository.save(chemical);


	}
}
