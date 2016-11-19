package easyclean.timesheets.times;

import java.util.List;

public class PayslipByEmployee {

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
