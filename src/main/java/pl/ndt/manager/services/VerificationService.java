package pl.ndt.manager.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.CustomerDTO;
import pl.ndt.manager.dto.MeasuringEquipmentDTO;
import pl.ndt.manager.dto.VerificationDTO;
import pl.ndt.manager.model.Customer;
import pl.ndt.manager.model.MeasuringEquipment;
import pl.ndt.manager.model.Verification;
import pl.ndt.manager.model.enums.DocumentIsValid;
import pl.ndt.manager.repository.MeasuringEquipmentRepository;
import pl.ndt.manager.repository.VerificationRepository;
import pl.ndt.manager.utils.DateConverter;

@Service
public class VerificationService {

	@Autowired
	private MeasuringEquipmentRepository measuringEquipmentRepository;
	@Autowired
	private VerificationRepository verificationRepository;
	private DateConverter dateConverter;

	/**
	 * Creates list of all Periodical Verifications for specific Measuring
	 * Device
	 * 
	 * @param id
	 *            Measuring Device id
	 * @return Periodical Verifications list
	 */
	public List<VerificationDTO> getVerifications(Long id) {
		MeasuringEquipment measuringEquipment = measuringEquipmentRepository.findOne(id);
		List<Verification> verifications = verificationRepository.findByMeasuringEquipment(measuringEquipment);

		dateConverter = new DateConverter();

		List<VerificationDTO> verificationsDTO = new ArrayList<>();

		for (Verification verification : verifications) {
			VerificationDTO verificationDTO = new VerificationDTO();
			verificationDTO.setId(verification.getId());
			verificationDTO.setCertificateNumber(verification.getCertificateNumber());
			verificationDTO
					.setDateOfVerification(dateConverter.createDateToString(verification.getDateOfVerification()));
			verificationDTO.setDoneBy(verification.getDoneBy());
			verificationDTO.setTypeOfControl(verification.getTypeOfControl());

			verificationDTO.setFinalDateOfVerification(
					dateConverter.createDateToString(verification.getFinalDateOfVerification()));

			if (verification.getFinalDateOfVerification().isAfter(LocalDateTime.now())) {
				verificationDTO.setDocumentIsValid(DocumentIsValid.VALID);
			} else {
				verificationDTO.setDocumentIsValid(DocumentIsValid.EXPIRED);
			}
			verificationsDTO.add(verificationDTO);
		}

		return verificationsDTO;
	}

	/**
	 * Saves Periodical Verification in database
	 * 
	 * @param id
	 *            Periodical Verification id
	 * @param verificationDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */
	public void saveVerification(Long id, VerificationDTO verificationDTO) {
		MeasuringEquipment measuringEquipment = measuringEquipmentRepository.findOne(id);
		dateConverter = new DateConverter();

		Verification verification = new Verification();
		verification.setId(verificationDTO.getId());
		verification.setCertificateNumber(verificationDTO.getCertificateNumber());
		LocalDateTime dateOfVerification = dateConverter.createDateFromString(verificationDTO.getDateOfVerification(),
				0, 0);
		verification.setDateOfVerification(dateOfVerification);
		LocalDateTime finalDateOfVerification = dateOfVerification
				.plusYears(measuringEquipment.getFerquencyOfVerification());
		verification.setFinalDateOfVerification(finalDateOfVerification);
		verification.setDoneBy(verificationDTO.getDoneBy());
		verification.setTypeOfControl(verificationDTO.getTypeOfControl());
		verification.setMeasuringEquipment(measuringEquipment);

		verificationRepository.save(verification);
	}

}
