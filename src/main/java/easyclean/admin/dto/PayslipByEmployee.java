package easyclean.admin.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayslipByEmployee implements Serializable{
	private String startDate;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	private String endDate;
	private Employee employee;
	private List<TimeSheets> timeSheets;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<TimeSheets> getTimeSheets() {
		return timeSheets;
	}
	public void setTimeSheets(List<TimeSheets> timeSheets) {
		this.timeSheets = timeSheets;
	}
}
