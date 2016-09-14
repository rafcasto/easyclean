package org.easyclean.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public Employee create(@RequestBody Employee emp){
		Employee result = employeeRepository.save(emp);
		
		return result;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/{employeeId}")
	public Employee get(@PathVariable String employeeId){
		return employeeRepository.findOne(employeeId);
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object[] get(){
		return  employeeRepository.findAll().toArray();
	}
	
	
	@RequestMapping(value = "/findAll/{employeeName}", method = RequestMethod.GET)
	public Object[] getEmployeesByName(String employeeName){
		return  employeeRepository.findByThePersonsFirstname(employeeName).toArray();
	}
}
