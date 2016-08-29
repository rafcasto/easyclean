package easyclean.admin.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
	
	private String id;
	
	private String companyCode;
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	private String employeeCodigo;
	public String getEmployeeCodigo() {
		return employeeCodigo;
	}
	public void setEmployeeCodigo(String employeeCodigo) {
		this.employeeCodigo = employeeCodigo;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeIRD() {
		return employeeIRD;
	}
	public void setEmployeeIRD(String employeeIRD) {
		this.employeeIRD = employeeIRD;
	}
	public Date getEmployeeStartDate() {
		return employeeStartDate;
	}
	public void setEmployeeStartDate(Date employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getEmployeEndDate() {
		return employeEndDate;
	}
	public void setEmployeEndDate(Date employeEndDate) {
		this.employeEndDate = employeEndDate;
	}

	private String employeeEmail;
	private String employeeGender;
	private String employeePhone;
	private String employeeIRD;
	private Date employeeStartDate;
	private boolean isActive;
	private Date employeEndDate;
	 
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	private String fullName;
	
	
}
