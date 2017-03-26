package pl.ndt.manager.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ndt.manager.model.Document;
import pl.ndt.manager.model.Employee;
import pl.ndt.manager.repository.DocumentRepository;
import pl.ndt.manager.repository.UserRepository;
@Controller
public class MainControler {
	
	
	private UserRepository userRepository;
	private DocumentRepository documentRepository;
	@Autowired
	 public MainControler(UserRepository userRepository,DocumentRepository documentRepository) {
		this.userRepository =userRepository;
		this.documentRepository = documentRepository;
	}
	@RequestMapping("/")
	public String showLoginPage() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){
		List<Document>allDocuments = (List<Document>) documentRepository.findAll();
		System.out.println(allDocuments);
		return "main";
	}
}
