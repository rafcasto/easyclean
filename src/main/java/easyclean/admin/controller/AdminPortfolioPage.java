package easyclean.admin.controller;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easyclean.admin.dto.Clients;
import easyclean.admin.model.portfolio.portfolioService;


@Controller()
@RequestMapping("/portfolio")
public class AdminPortfolioPage {
	
	static Logger log = Logger.getLogger(AdminPortfolioPage.class.getName());

	
	@Autowired
	portfolioService serviceClients;
	
	@RequestMapping(value = "/show_portfolio", method = RequestMethod.GET)
	public String show_Clientss(Model model){
		model.addAttribute("clientsList",serviceClients.findAll());				
		return "admindashboard/portfolio";
	}
	
	
	@RequestMapping(value = "/save_portfolio",method = RequestMethod.POST)
	public String save_Clients(@Valid Clients clients , BindingResult bindingResult, Model model){
		 if (bindingResult.hasErrors()) {
			 log.error("Something wrong with the validation form" + bindingResult.getAllErrors().toString());
	            return "admindashboard/portfolio_add";
	      }else{
	    	  serviceClients.addClients(clients);
	      }		 		 
		return "redirect:/portfolio/show_portfolio";
	}
	
	@RequestMapping(value = "/add_portfolio",method = RequestMethod.GET)
	public String admin_Clients_add(Model model){
		model.addAttribute("clients",new Clients());			
		return "admindashboard/portfolio_add";
	}
}
