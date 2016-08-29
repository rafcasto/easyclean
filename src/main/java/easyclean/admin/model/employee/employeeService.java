package easyclean.admin.model.employee;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import easyclean.admin.dto.Employee;

@Service
public interface employeeService {
	public ArrayList<Employee> findAll();
	public Employee addEmployee(Employee employeeDTO);
}
