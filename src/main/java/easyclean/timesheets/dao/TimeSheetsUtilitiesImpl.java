package easyclean.timesheets.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import easyclean.timesheets.times.PaySleep;
import easyclean.timesheets.times.PayslipByEmployee;
import easyclean.timesheets.times.Roster;
import easyclean.timesheets.times.RosterTemplate;
import easyclean.timesheets.times.TimeSheets;

@Component
public class TimeSheetsUtilitiesImpl implements TimeSheetsUtilitiesService{

	
	static Logger log = Logger.getLogger(TimeSheetsUtilitiesImpl.class.getName());
	@Override
	public List<TimeSheets> getTimeSheet(String startDate,String endDate,List<Roster> rosters) {
		// TODO Auto-generated method stub
		List<TimeSheets> listOfTiemsheets = new ArrayList<TimeSheets>();
		try{

		for(Roster roster:rosters){
			for(LocalDate date = convertDate(startDate); (date.isBefore(convertDate(endDate) )|| date.equals(convertDate(endDate)) );date = date.plusDays(1)){			
				for(RosterTemplate rosterTemplate : roster.getRosterTemplate()){
					if(date.getDayOfWeek().name().equals(rosterTemplate.getDay())){	
						if(isVildTemplate(roster, rosterTemplate, date)){
						listOfTiemsheets.add(getTimeSheets(roster, rosterTemplate, date));
						
						}
					}
				}									
			}			
		}
			
		}catch(Exception exption){
			exption.printStackTrace();
		}
		return listOfTiemsheets;
	}
	
	private boolean isVildTemplate(Roster roster,RosterTemplate rosterTemplate,LocalDate date){
		boolean isvalid= true;
		if(roster.getClients().equals("") || roster.getClients().equals(null)){
			return false;
		}
		if(rosterTemplate.getEmployee().equals("") || rosterTemplate.getEmployee().equals(null)){
			return false;
		}
		if(roster.getClients().getCompanyCode().equals("") || roster.getClients().getCompanyCode().equals(null)){
			return false;
		}
		if(rosterTemplate.getTotalHours().equals("") || rosterTemplate.getTotalHours().equals(null)){
			return false;
		}
		return isvalid;
	}
	
	private TimeSheets getTimeSheets(Roster roster,RosterTemplate rosterTemplate,LocalDate date){
		TimeSheets timeSheets = new TimeSheets();
		
		timeSheets.setClient(roster.getClients());
		timeSheets.setEmployee(rosterTemplate.getEmployee());		
		timeSheets.setStartTime(rosterTemplate.getStartTime());
		timeSheets.setEndTime(rosterTemplate.getEndTime());		
		timeSheets.setDay(date.toString());
		timeSheets.setHours(rosterTemplate.getTotalHours());
		timeSheets.setTotalHours(rosterTemplate.getTotalHours() * rosterTemplate.getEmployee().getProfile().getSalaryPerHour());
		return timeSheets;
	}
	
	private LocalDate convertDate(String stringdate){
		LocalDate date = null; 
		try {
			date = LocalDate.parse(stringdate, DateTimeFormatter.ISO_DATE);		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Override
	public List<PayslipByEmployee> getPayslipByEmployee(PaySleep paylip) {
		// TODO Auto-generated method stub
		List<PayslipByEmployee> payslipByEmployee = new ArrayList<>();
		for(TimeSheets tms : paylip.getTimeSheets().stream().filter(distinctByKey(p -> p.getEmployee().getEmployeeEmail())).collect(Collectors.toList())){
			PayslipByEmployee employeePayslip = new PayslipByEmployee();
			employeePayslip.setEmployee(tms.getEmployee());
			System.out.println("Setting employee success");
			employeePayslip.setTimeSheets(paylip.getTimeSheets().stream().filter(p -> p.getEmployee().getEmployeeEmail().equals(tms.getEmployee().getEmployeeEmail())).collect(Collectors.toList()));
			System.out.println("Setting timesheets by employee success");
			payslipByEmployee.add(employeePayslip);									
		}
		return payslipByEmployee;
	}

	
	
	

}
