package org.easyclean.employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
	 @Query("{employeeName : {$regex : ?0}}")
	  List<Employee> findByThePersonsFirstname(String firstname);
}
