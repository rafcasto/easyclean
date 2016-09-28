package easyclean.timesheets.times;

public class TimeSheets {
	
	private String date;
	
	public String getDay() {
		return date;
	}
	public void setDay(String date) {
		this.date = date;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getCompanyCod() {
		return companyCod;
	}
	public void setCompanyCod(String companyCod) {
		this.companyCod = companyCod;
	}
	
	private Double totalHours;
	public Double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	private String startTime; 
	private String endTime;
	
	private double hours;
	private Clients client;
	private Employee employee;
	private String companyCod;
	
}
