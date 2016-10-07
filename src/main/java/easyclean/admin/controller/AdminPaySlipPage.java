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

import easyclean.admin.dto.Employee;
import easyclean.admin.dto.PaySleep;
import easyclean.admin.model.roster.rosterService;
import easyclean.admin.model.timesheets.payslipService;

@Controller()
@RequestMapping("/payslip")
public class AdminPaySlipPage {
	@Autowired
	payslipService paySlip;
	
	@Autowired
	rosterService rosterService;
	
	static Logger log = Logger.getLogger(AdminPaySlipPage.class.getName());

	
	@RequestMapping(value = "/show_payslip", method = RequestMethod.GET)
	public String show_employees(Model model){
		model.addAttribute("payslipList",paySlip.findAll());				
		return "admindashboard/payslip";
	}
	
	
	@RequestMapping(value = "/add_payslip",method = RequestMethod.GET)
	public String admin_employee_add(Model model){
		model.addAttribute("payslip",new PaySleep());			
		return "admindashboard/payslip_add";
	}
	
	@RequestMapping(value = "/save_payslip",method = RequestMethod.POST)
	public String save_employee(@Valid PaySleep payslip , BindingResult bindingResult, Model model){
		 if (bindingResult.hasErrors()) {
			 log.error("Something wrong with the validation form" + bindingResult.getAllErrors().toString());
	            return "admindashboard/payslip_add";
	      }else{
	    	  payslip.setRosters(rosterService.findAll());
	    	  payslip =  paySlip.addPaySleep(payslip);
	      }		 		 
		return "redirect:/payslip/show_payslip/"+payslip.getId();
	}
	
	@RequestMapping(value = "/show_payslip/{clientId}", method = RequestMethod.GET)
	public String show_Clientss(@PathVariable("clientId") String clientId,  Model model){		
		model.addAttribute("payslip",paySlip.findPaySlip(clientId));
		return "admindashboard/payslip_add";
	}
	
}
