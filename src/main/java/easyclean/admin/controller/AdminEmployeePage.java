package easyclean.admin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import easyclean.admin.model.employee.employeeService;


@Controller
public class AdminEmployeePage {
	
	@Autowired
	employeeService serviceEmployee;
	
	@RequestMapping({"/admin_employee"})
	public String admin_employee(Model model){
		model.addAttribute("employeesList",serviceEmployee.findAll());						
		return "admindashboard/employees";
	}
}
