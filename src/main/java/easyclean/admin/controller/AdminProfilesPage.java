package easyclean.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easyclean.admin.dto.Profiles;
import easyclean.admin.model.profiles.ProfilesServices;

@Controller()
@RequestMapping("/profiles")
public class AdminProfilesPage {

	static Logger log = Logger.getLogger(AdminProfilesPage.class.getName());
	
	@Autowired
	ProfilesServices profiles;

	@RequestMapping(value = "/show_profiles", method = RequestMethod.GET)
	public String show_employees(Model model){
		model.addAttribute("profileList",profiles.findAll());				
		return "admindashboard/profiles";
	}
	
	@RequestMapping(value = "/add_employee",method = RequestMethod.GET)
	public String admin_employee_add(Model model){
		model.addAttribute("profiles",new Profiles());			
		return "admindashboard/profiles_add";
	}
}
