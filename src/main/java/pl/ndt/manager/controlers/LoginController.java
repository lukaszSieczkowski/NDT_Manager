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

import pl.ndt.manager.dto.UserDTO;
import pl.ndt.manager.exampleData.ExampleDataBase;
import pl.ndt.manager.services.UserService;

@Controller
@SessionAttributes("logedEmployee")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private ExampleDataBase exampleDataBase;
	/**
	 * Shows login page
	 * 
	 * @return index view
	 */
	@RequestMapping("/")
	public String showLoginPage() {
		
		
		return "index";
	}

	/**
	 * Shows login or main page according to present login data
	 * 
	 * @param model
	 *            Holder or attributes
	 * @param email
	 *            user's email
	 * @param password
	 *            user's password
	 * @return index or main view
	 */
	@PostMapping("/login")
	public String login(Model model, @RequestParam String email, @RequestParam String password) {
		
		//********* Example Database***********//
		
		//  exampleDataBase.prepareDataBase();
		
		//*********************************************//
		
		UserDTO userDTO = null;
		try {
			userDTO = userService.createUser(email, password);
		} catch (NullPointerException e) {
			String message = "Incorect email address or password";
			model.addAttribute("message", message);
			return "index";
		}
		model.addAttribute("logedEmployee", userDTO);
		return "main";
	}

	/**
	 * Clean all attributes
	 * 
	 * @param request
	 *            Giving access to general request metadata.
	 * @param status
	 *            Clean up a session,
	 * @return index view
	 */
	@RequestMapping("/logout")
	public String logout(WebRequest request, SessionStatus status) {
		status.setComplete();
		request.removeAttribute("logedEmployee", WebRequest.SCOPE_SESSION);

		return "index";
	}
}
