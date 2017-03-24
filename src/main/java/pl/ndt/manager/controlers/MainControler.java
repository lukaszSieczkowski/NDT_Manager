package pl.ndt.manager.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainControler {
	
	@RequestMapping("/")
	public String showMain() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "main";
	}
}
