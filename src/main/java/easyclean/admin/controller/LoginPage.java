package easyclean.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPage {

	@RequestMapping({"/","/login"})
	public String index(){
		return "login";
	}
	
	
	
}
