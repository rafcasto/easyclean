package easyclean.admin.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easyclean.admin.dto.Clients;
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
	
	@RequestMapping(value = "/add_profiles",method = RequestMethod.GET)
	public String admin_employee_add(Model model){
		model.addAttribute("profiles",new Profiles());			
		return "admindashboard/profiles_add";
	}
	
	@RequestMapping(value = "/delete_profiles/{idProfile}", method = RequestMethod.GET)
	public String deleteClients(@PathVariable String idProfile){
		Profiles dto = profiles.findProfile(idProfile);
		profiles.removeProfile(dto);		
		return "redirect:/profiles/show_profiles";
	}
	
	@RequestMapping(value = "/save_profile",method = RequestMethod.POST)
	public String save_Clients(@Valid Profiles profile , BindingResult bindingResult, Model model){
		 if (bindingResult.hasErrors()) {
			 log.error("Something wrong with the validation form" + bindingResult.getAllErrors().toString());
	            return "admindashboard/profiles_add";
	      }else{
	    	  profiles.addProfile(profile);
	      }		 		 
		return "redirect:/profiles/show_profiles";
	}
}
