package easyclean.admin.controller;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easyclean.admin.dto.Clients;
import easyclean.admin.dto.Roster;
import easyclean.admin.model.portfolio.portfolioService;
import easyclean.admin.model.roster.rosterService;



@Controller()
@RequestMapping("/roster")
public class AdminRosterPage {
	
	static Logger log = Logger.getLogger(AdminRosterPage.class.getName());

	@Autowired
	rosterService rosterService;
	
	
	@RequestMapping(value = "/show_roster/{clientId}", method = RequestMethod.GET)
	public String show_Clientss(@PathVariable("clientId") String clientId,  Model model){		
		model.addAttribute("roster",rosterService.initRoster(clientId));
		return "admindashboard/roster";
	}
	
	
	@RequestMapping(value = "/save_roster",method = RequestMethod.POST)
	public String save_Roster(@Valid Roster roster , BindingResult bindingResult, Model model){
		 if (bindingResult.hasErrors()) {
			 log.error("Something wrong with the validation form" + bindingResult.getAllErrors().toString());
	            return "admindashboard/roster";
	      }else{
	    	  
	      }		 		 
		return "admindashboard/roster";
	}
	
	@RequestMapping(value = "/save_roster", params = "addRow"	,method = RequestMethod.POST)
	public String addRow(@Valid Roster roster, BindingResult bindingResult, Model model){
		
		
		roster.setRosterTemplate(rosterService.addRow(roster.getRosterTemplate()));		
		rosterService.addRoster(roster);
		return "redirect:/roster/show_roster/"+roster.getId();
	}
	
	
	@RequestMapping(value = "/save_roster", params = "removeRow"	,method = RequestMethod.POST)
	public String removeRow(@Valid Roster roster, BindingResult bindingResult, Model model,HttpServletRequest req){
		int index = Integer.valueOf(req.getParameter("removeRow"));		
		roster.setRosterTemplate(rosterService.removeRow(roster.getRosterTemplate(),index));		
		rosterService.addRoster(roster);
		return "redirect:/roster/show_roster/"+roster.getId();
	}
	
	@RequestMapping(value = "/add_roster",method = RequestMethod.GET)
	public String admin_Clients_add(Model model){
		model.addAttribute("clients",new Clients());			
		return "admindashboard/roster_add";
	}
}
