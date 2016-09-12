package easyclean.admin.model.employee;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import easyclean.admin.dto.Employee;
import easyclean.admin.model.resttemplate.resttemplateCofiguration;
@Component
@PropertySource("classpath:conf.properties")
public class EmployeesImpl implements employeeService{
	@Autowired
	resttemplateCofiguration<Employee> result;
	@Value("${employee.port}")
	private String servicePort;
	@Value("${service.url}")
	private String serviceURL;
	@Value("${employee}")	
	private String employeeService;
	@Value("${employee.findall}")
	private String employeeFindALL;
	
	
	
	@Override
	public ArrayList<Employee> findAll() {
		// TODO Auto-generated method stub
		String restTemplate = serviceURL+":"+servicePort+"/" + employeeFindALL;		
		ResponseEntity<Employee[]> employeeList = result.getRestTemplate().getForEntity(restTemplate, Employee[].class);
		ArrayList<Employee> listOfEmployees = new ArrayList<Employee>(Arrays.asList(employeeList.getBody()));
		return listOfEmployees;
	}

	@Override
	public Employee addEmployee(Employee employeeDTO) {
		// TODO Auto-generated method stub		
		return  result.getRestTemplatePost(employeeDTO, employeeService,servicePort);
	}

}
