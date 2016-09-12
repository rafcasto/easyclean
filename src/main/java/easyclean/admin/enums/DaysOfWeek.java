package easyclean.admin.enums;

public enum DaysOfWeek {
	MONDAY("Monday"),
	TUESDAY("Tuesday"),
	WEDNESDAY("Wednesday"),
	THURSDAY("Thursday"),
	FRIDAY("Friday"),
	SATURDAY("Saturday"),
	SUNDAY("Sunday");
	
	
	
	private String day;
	
	DaysOfWeek(final String day){
		this.day = day;
	}
	
	public String getDay(){
		return this.day;
	}
}
