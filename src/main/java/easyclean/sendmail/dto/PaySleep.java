package easyclean.sendmail.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class PaySleep {
	@Id
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
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
	public List<TimeSheets> getTimeSheets() {
		return timeSheets;
	}
	public void setTimeSheets(List<TimeSheets> timeSheets) {
		this.timeSheets = timeSheets;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;	
	}
	
	private List<Roster> rosters;
	
	public List<Roster> getRosters() {
		return rosters;
	}
	public void setRosters(List<Roster> rosters) {
		this.rosters = rosters;
	}
	private List<PayslipByEmployee> paysliptPerEmployee;
	public List<PayslipByEmployee> getPaysliptPerEmployee() {
		return paysliptPerEmployee;
	}
	public void setPaysliptPerEmployee(List<PayslipByEmployee> paysliptPerEmployee) {
		this.paysliptPerEmployee = paysliptPerEmployee;
	}

	private String companyCode;
	private String startDate;
	private String endDate;
	private List<TimeSheets> timeSheets;
	private double total;
	
}
