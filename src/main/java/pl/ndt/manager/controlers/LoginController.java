package pl.ndt.manager.controlers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;


import pl.ndt.manager.model.Employee;
import pl.ndt.manager.services.EmployeeService;

@Controller
@SessionAttributes("employee")
public class LoginController {
	
	
	private EmployeeService employeeService;
	@Autowired
	public LoginController( EmployeeService employeeService){
		
		this.employeeService = employeeService;
	}
	
	
	@RequestMapping("/")
	public String showLoginPage() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Model model,@RequestParam String email,@RequestParam String password){
		
		Employee employee; 
		
		try{
			employee= employeeService.findEmployee(email,password);
		}catch(NullPointerException e){
			String message = "Incorect email address or password";
			model.addAttribute("message",message);
			return "index";
		}
		model.addAttribute("employee",employee);
		return "main";
	}
	@RequestMapping("/logout")
	public String logout(WebRequest request, SessionStatus status) {
		status.setComplete();
		request.removeAttribute("employee", WebRequest.SCOPE_SESSION);
		
		return "index";
	}
}
 