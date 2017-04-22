package pl.ndt.manager.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.EmployeeDTO;

import pl.ndt.manager.model.Document;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.model.Location;
import pl.ndt.manager.model.PersonalDocument;
import pl.ndt.manager.model.User;
import pl.ndt.manager.model.enums.EmployeePositon;
import pl.ndt.manager.model.enums.UserRole;
import pl.ndt.manager.repository.EmployeeRepository;
import pl.ndt.manager.repository.LocationRepository;
import pl.ndt.manager.repository.UserRepository;
import pl.ndt.manager.utils.Mail;
import pl.ndt.manager.utils.PasswordGenerator;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;

	/**
	 * Prepares list of all employees
	 * 
	 * @return Employees list
	 */

	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();

		List<EmployeeDTO> employessDTO = new ArrayList<>();

		for (Employee employee : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employee.getId());
			employeeDTO.setFirstName(employee.getFirstName());
			employeeDTO.setLastName(employee.getLastName());
			employeeDTO.setRole(employee.getUser().getRole());
			employeeDTO.setEmail(employee.getUser().getEmail());
			employeeDTO.setLocationName(employee.getLocation().getInstitutionName());
			employeeDTO.setEmployeePositon(employee.getEmployeePosition());
			employessDTO.add(employeeDTO);
		}
		return employessDTO;
	}

	/**
	 * Saves Employee in database
	 * 
	 * @param employeeDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */
	public void saveEmployee(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		User user = new User();
		List<PersonalDocument> documentsList = new ArrayList<>();

		String institutionName = employeeDTO.getLocationName();
		Location location = locationRepository.getByInstitutionName(institutionName);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePasword();
		String decryptedPassword = DigestUtils.sha256Hex(password);

		employee.setId(employeeDTO.getId());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmployeePosition(employeeDTO.getEmployeePositon());
		employee.setDocumentsList(documentsList);
		employee.setUser(user);
		employee.setLocation(location);

		user.setEmail(employeeDTO.getEmail());
		user.setRole(employeeDTO.getRole());
		user.setPassword(decryptedPassword);
		user.setEmployee(employee);
		employee.setUser(user);
		userRepository.save(user);
		employeeRepository.save(employee);

		Mail mail = new Mail();
		String subject = mail.prepareSubjectNewUser();
		String content = mail.prepareContentNewUser(employeeDTO, password);
		mail.sendMail(employeeDTO.getEmail(), content, subject);

	}

	/**
	 * Updates Employee in database
	 * 
	 * @param employeeDTO
	 *            Transfer object with values transfered from input form into
	 *            the database
	 */

	public void updateEmployee(EmployeeDTO employeeDTO) {

		String institutionName = employeeDTO.getLocationName();
		Location location = locationRepository.getByInstitutionName(institutionName);

		long id = employeeDTO.getId();
		Employee employeeToUpdate = employeeRepository.findOne(id);
		User userToUpdate = userRepository.findOne(id);

		employeeToUpdate.setFirstName(employeeDTO.getFirstName());
		employeeToUpdate.setLastName(employeeDTO.getLastName());
		employeeToUpdate.setEmployeePosition(employeeDTO.getEmployeePositon());
		employeeToUpdate.setLocation(location);
		userToUpdate.setEmail(employeeDTO.getEmail());
		userToUpdate.setRole(employeeDTO.getRole());
		userToUpdate.setEmployee(employeeToUpdate);
		userRepository.save(userToUpdate);
	}
}
