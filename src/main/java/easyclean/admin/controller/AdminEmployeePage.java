package easyclean.admin.controller;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import easyclean.admin.dto.Employee;
import easyclean.admin.model.employee.employeeService;


@Controller()
@RequestMapping("/employee")
public class AdminEmployeePage {
	
	static Logger log = Logger.getLogger(AdminEmployeePage.class.getName());

	
	@Autowired
	employeeService serviceEmployee;
	
	@RequestMapping(value = "/show_employees", method = RequestMethod.GET)
	public String show_employees(Model model){
		model.addAttribute("employeesList",serviceEmployee.findAll());				
		return "admindashboard/employees";
	}
	
	
	@RequestMapping(value = "/save_employee",method = RequestMethod.POST)
	public String save_employee(@Valid Employee employee , BindingResult bindingResult, Model model){
		 if (bindingResult.hasErrors()) {
			 log.error("Something wrong with the validation form" + bindingResult.getAllErrors().toString());
	            return "admindashboard/employees_add";
	      }else{
	    	  serviceEmployee.addEmployee(employee);
	      }
		 System.out.println("Date "  + employee.getEmployeeStartDate().toString());
		 
		return "redirect:/employee/show_employees";
	}
	
	@RequestMapping(value = "/add_employee",method = RequestMethod.GET)
	public String admin_employee_add(Model model){
		model.addAttribute("employee",new Employee());			
		return "admindashboard/employees_add";
	}
}
