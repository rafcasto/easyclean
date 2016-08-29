package easyclean.admin.model.employee;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import easyclean.admin.dto.Employee;
@Component
@PropertySource("classpath:conf.properties")
public class EmployeesImpl implements employeeService{

	@Value("${service.url}")
	private String serviceURL;
	@Value("${employee}")	
	private String employeeService;
	@Value("${employee.findall}")
	private String employeeFindALL;
	
	
	
	@Override
	public ArrayList<Employee> findAll() {
		// TODO Auto-generated method stub
		String restTemplate = serviceURL + employeeFindALL;
		RestTemplate result = new RestTemplate();
		System.out.println("Print endpoint " + restTemplate);
		ResponseEntity<Employee[]> employeeList = result.getForEntity(restTemplate, Employee[].class);
		ArrayList<Employee> listOfEmployees = new ArrayList<Employee>(Arrays.asList(employeeList.getBody()));
		return listOfEmployees;
	}

	@Override
	public Employee addEmployee(Employee employeeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
