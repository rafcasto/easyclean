package easyclean.admin.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable{
	



	private Profiles profile;
	
	public Profiles getProfile() {
		return profile;
	}
	public void setProfile(Profiles profile) {
		this.profile = profile;
	}


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

	@NotEmpty
	private String employeeEmail;
	private String employeeGender;
	@NotEmpty
	@Size(min=10,max=18)
	private String employeePhone;
	@NotEmpty
	@Size(min=8,max=9)	
	private String employeeIRD;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date employeeStartDate;
	private boolean isActive;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date employeEndDate;
	@NotEmpty
	@Size(min= 2, max = 30)
	private String employeeName;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	@NotEmpty
	@Size(min= 2, max = 30)
	private String employeeLastName;
	
	
	
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
