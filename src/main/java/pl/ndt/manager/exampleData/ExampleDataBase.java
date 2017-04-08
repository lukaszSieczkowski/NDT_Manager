package pl.ndt.manager.exampleData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.model.Document;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.model.JaegerTest;
import pl.ndt.manager.model.NdtCertificate;
import pl.ndt.manager.model.User;
import pl.ndt.manager.model.enums.CorerctlyEyeCondition;
import pl.ndt.manager.model.enums.EmployeePositon;
import pl.ndt.manager.model.enums.NdtMethod;
import pl.ndt.manager.model.enums.Sector;
import pl.ndt.manager.model.enums.UserRole;
import pl.ndt.manager.repository.EmployeeRepository;
import pl.ndt.manager.repository.JaegerTestRepository;
import pl.ndt.manager.repository.NdtCertificateRepository;
import pl.ndt.manager.repository.UserRepository;

@Service
public class ExampleDataBase {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NdtCertificateRepository ndtCertificateRepository;
	@Autowired
	private JaegerTestRepository jaegerTestRepository;


	public void prepareDataBase() {
		List<Document> documentsList1 = new ArrayList<>();
		List<Document> documentsList2 = new ArrayList<>();
		List<Document> documentsList3 = new ArrayList<>();
		List<Document> documentsList4 = new ArrayList<>();
		List<Document> documentsList5 = new ArrayList<>();

		Employee employee1 = new Employee();
		User user1 = new User();

		employee1.setFirstName("Tadeusz");
		employee1.setLastName("Nowak");
		employee1.setEmployeePosition(EmployeePositon.NDT_MANAGER);
		employee1.setDocumentsList(documentsList1);
		employee1.setUser(user1);
		user1.setEmail("tadeusz.nowak@frm.pl");
		user1.setPassword("qwerty");
		user1.setRole(UserRole.ADMIN);
		user1.setEmployee(employee1);
		employee1.setUser(user1);

		Employee employee2 = new Employee();
		User user2 = new User();
		employee2.setFirstName("Bonifacy");
		employee2.setLastName("Plomba");
		employee2.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee2.setDocumentsList(documentsList2);
		employee2.setUser(user2);
		user2.setEmail("bonifacy.bomba@frm.pl");
		user2.setPassword("qwerty");
		user2.setRole(UserRole.USER);
		user2.setEmployee(employee2);
		employee2.setUser(user2);

		Employee employee3 = new Employee();
		User user3 = new User();
		employee3.setFirstName("Teodor");
		employee3.setLastName("Wierci�ta");
		employee3.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee3.setDocumentsList(documentsList3);
		employee3.setUser(user3);
		user3.setEmail("teodor.wiercipieta@frm.pl");
		user3.setPassword("qwerty");
		user3.setRole(UserRole.USER);
		user3.setEmployee(employee3);
		employee3.setUser(user3);

		Employee employee4 = new Employee();
		User user4 = new User();
		employee4.setFirstName("Janusz");
		employee4.setLastName("Polak");
		employee4.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee4.setDocumentsList(documentsList4);
		employee4.setUser(user4);
		user4.setEmail("janusz.polak@frm.pl");
		user4.setPassword("qwerty");
		user4.setRole(UserRole.USER);
		user4.setEmployee(employee4);
		employee4.setUser(user4);

		Employee employee5 = new Employee();
		User user5 = new User();
		employee5.setFirstName("Pankracy");
		employee5.setLastName("Ma�lak");
		employee5.setEmployeePosition(EmployeePositon.NDT_INSPECTOR);
		employee5.setDocumentsList(documentsList5);
		employee5.setUser(user5);
		user5.setEmail("panracy.maslak@frm.pl");
		user5.setPassword("qwerty");
		user5.setRole(UserRole.USER);
		user5.setEmployee(employee5);
		employee5.setUser(user5);

		NdtCertificate ndtCert1 = new NdtCertificate();
		ndtCert1.setIssueDate(LocalDateTime.of(2015, 10, 3, 0, 0));
		ndtCert1.setExpirationDate(LocalDateTime.of(2015, 10, 3, 0, 0).plusYears(5));
		ndtCert1.setIssuedBy("UDT-Cert");
		ndtCert1.setFileName("aa");
		ndtCert1.setEmployee(employee1);
		ndtCert1.setDocumentNumber("Doc-1");
		ndtCert1.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert1.setNdtMethod(NdtMethod.MT_2);

		NdtCertificate ndtCert2 = new NdtCertificate();
		ndtCert2.setIssueDate(LocalDateTime.of(2016, 3, 3, 0, 0));
		ndtCert2.setExpirationDate(LocalDateTime.of(2016, 3, 3, 0, 0).plusYears(5));
		ndtCert2.setIssuedBy("UDT-Cert");
		ndtCert2.setFileName("bb");
		ndtCert2.setEmployee(employee1);
		ndtCert2.setDocumentNumber("Doc-2");
		ndtCert2.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert2.setNdtMethod(NdtMethod.UT_2);

		NdtCertificate ndtCert3 = new NdtCertificate();
		ndtCert3.setIssueDate(LocalDateTime.of(2017, 4, 3, 0, 0));
		ndtCert3.setExpirationDate(LocalDateTime.of(2017, 4, 3, 0, 0).plusYears(5));
		ndtCert3.setIssuedBy("UDT-Cert");
		ndtCert3.setFileName("cc");
		ndtCert3.setEmployee(employee2);
		ndtCert3.setDocumentNumber("Doc-3");
		ndtCert3.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert3.setNdtMethod(NdtMethod.PT_2);

		NdtCertificate ndtCert4 = new NdtCertificate();
		ndtCert4.setIssueDate(LocalDateTime.of(2015, 3, 3, 0, 0));
		ndtCert4.setExpirationDate(LocalDateTime.of(2015, 3, 3, 0, 0).plusYears(5));
		ndtCert4.setIssuedBy("UDT-Cert");
		ndtCert4.setFileName("dd");
		ndtCert4.setEmployee(employee2);
		ndtCert4.setDocumentNumber("Doc-4");
		ndtCert4.setSector(Sector.METL_PRE_AND_IN_SERVICE);
		ndtCert4.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert5 = new NdtCertificate();
		ndtCert5.setIssueDate(LocalDateTime.of(2016, 10, 3, 0, 0));
		ndtCert5.setExpirationDate(LocalDateTime.of(2016, 10, 3, 0, 0).plusYears(5));
		ndtCert5.setIssuedBy("UDT-Cert");
		ndtCert5.setFileName("ee");
		ndtCert5.setEmployee(employee3);
		ndtCert5.setDocumentNumber("Doc-5");
		ndtCert5.setSector(Sector.AREOSPACE);
		ndtCert5.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert6 = new NdtCertificate();
		ndtCert6.setIssueDate(LocalDateTime.of(2017, 1, 3, 0, 0));
		ndtCert6.setExpirationDate(LocalDateTime.of(2017, 1, 3, 0, 0).plusYears(5));
		ndtCert6.setIssuedBy("UDT-Cert");
		ndtCert6.setFileName("ff");
		ndtCert6.setEmployee(employee3);
		ndtCert6.setDocumentNumber("Doc-6");
		ndtCert6.setSector(Sector.AREOSPACE);
		ndtCert6.setNdtMethod(NdtMethod.UT_2);

		NdtCertificate ndtCert7 = new NdtCertificate();
		ndtCert7.setIssueDate(LocalDateTime.of(2012, 1, 3, 0, 0));
		ndtCert7.setExpirationDate(LocalDateTime.of(2012, 1, 3, 0, 0).plusYears(5));
		ndtCert7.setIssuedBy("TUV");
		ndtCert7.setFileName("gg");
		ndtCert7.setEmployee(employee4);
		ndtCert7.setDocumentNumber("Doc-7");
		ndtCert7.setSector(Sector.RAILWAY);
		ndtCert7.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert8 = new NdtCertificate();
		ndtCert8.setIssueDate(LocalDateTime.of(2011, 10, 3, 0, 0));
		ndtCert8.setExpirationDate(LocalDateTime.of(2011, 10, 3, 0, 0).plusYears(5));
		ndtCert8.setIssuedBy("UDT-Cert");
		ndtCert8.setFileName("hh");
		ndtCert8.setEmployee(employee4);
		ndtCert8.setDocumentNumber("Doc-8");
		ndtCert8.setSector(Sector.RAILWAY);
		ndtCert8.setNdtMethod(NdtMethod.MT_2);

		NdtCertificate ndtCert9 = new NdtCertificate();
		ndtCert9.setIssueDate(LocalDateTime.of(2010, 10, 3, 0, 0));
		ndtCert9.setExpirationDate(LocalDateTime.of(2010, 10, 3, 0, 0).plusYears(5));
		ndtCert9.setIssuedBy("UDT-Cert");
		ndtCert9.setFileName("ii");
		ndtCert9.setEmployee(employee5);
		ndtCert9.setDocumentNumber("Doc-9");
		ndtCert9.setSector(Sector.METAL_MANUFACTURING);
		ndtCert9.setNdtMethod(NdtMethod.RT_2);

		NdtCertificate ndtCert10 = new NdtCertificate();
		ndtCert10.setIssueDate(LocalDateTime.of(2010, 10, 3, 0, 0));
		ndtCert10.setExpirationDate(LocalDateTime.of(2010, 10, 3, 0, 0).plusYears(5));
		ndtCert10.setIssuedBy("UDT-Cert");
		ndtCert10.setFileName("jj");
		ndtCert10.setEmployee(employee5);
		ndtCert10.setDocumentNumber("Doc-10");
		ndtCert10.setSector(Sector.METAL_MANUFACTURING);
		ndtCert10.setNdtMethod(NdtMethod.TOFD_2);
		
		JaegerTest jaegerTest1 = new JaegerTest();
		jaegerTest1.setIssueDate(LocalDateTime.of(2016, 3, 3, 0, 0));
		jaegerTest1.setExpirationDate(LocalDateTime.of(2017, 3, 3, 0, 0));
		jaegerTest1.setEmployee(employee1);
		jaegerTest1.setIssuedBy("Doctor");
		jaegerTest1.setFileName("aaa");
		jaegerTest1.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);

		JaegerTest jaegerTest2 = new JaegerTest();
		jaegerTest2.setIssueDate(LocalDateTime.of(2017, 3, 3, 0, 0));
		jaegerTest2.setExpirationDate(LocalDateTime.of(2018, 3, 3, 0, 0));
		jaegerTest2.setEmployee(employee2);
		jaegerTest2.setIssuedBy("Doctor");
		jaegerTest2.setFileName("bbb");
		jaegerTest2.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);
	
		JaegerTest jaegerTest3 = new JaegerTest();
		jaegerTest3.setIssueDate(LocalDateTime.of(2016, 4, 3, 0, 0));
		jaegerTest3.setExpirationDate(LocalDateTime.of(2017, 4, 3, 0, 0));
		jaegerTest3.setEmployee(employee3);
		jaegerTest3.setIssuedBy("Doctor");
		jaegerTest3.setFileName("ccc");
		jaegerTest3.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);
		
		JaegerTest jaegerTest4 = new JaegerTest();
		jaegerTest4.setIssueDate(LocalDateTime.of(2016, 8, 3, 0, 0));
		jaegerTest4.setExpirationDate(LocalDateTime.of(2017, 8, 3, 0, 0));
		jaegerTest4.setEmployee(employee4);
		jaegerTest4.setIssuedBy("Doctor");
		jaegerTest4.setFileName("ddd");
		jaegerTest4.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);
	
		JaegerTest jaegerTest5 = new JaegerTest();
		jaegerTest5.setIssueDate(LocalDateTime.of(2016, 10, 3, 0, 0));
		jaegerTest5.setExpirationDate(LocalDateTime.of(2017, 10, 3, 0, 0));
		jaegerTest5.setEmployee(employee5);
		jaegerTest5.setIssuedBy("Doctor");
		jaegerTest5.setFileName("aaa");
		jaegerTest5.setCorerctlyEyeCondition(CorerctlyEyeCondition.POSIVE);
	
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);

		ndtCertificateRepository.save(ndtCert1);
		ndtCertificateRepository.save(ndtCert2);
		ndtCertificateRepository.save(ndtCert3);
		ndtCertificateRepository.save(ndtCert4);
		ndtCertificateRepository.save(ndtCert5);
		ndtCertificateRepository.save(ndtCert6);
		ndtCertificateRepository.save(ndtCert7);
		ndtCertificateRepository.save(ndtCert8);
		ndtCertificateRepository.save(ndtCert9);
		ndtCertificateRepository.save(ndtCert10);
		
		jaegerTestRepository.save(jaegerTest1);
		jaegerTestRepository.save(jaegerTest2);
		jaegerTestRepository.save(jaegerTest3);
		jaegerTestRepository.save(jaegerTest4);
		jaegerTestRepository.save(jaegerTest5);

	}
}