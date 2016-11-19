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

import easyclean.timesheets.times.Employee;
import easyclean.timesheets.times.PayslipByEmployee;
import easyclean.timesheets.times.Roster;
import easyclean.timesheets.times.RosterTemplate;
import easyclean.timesheets.times.TimeSheets;

@Component
public class TimeSheetsUtilitiesImpl implements TimeSheetsUtilitiesService{

	
	static Logger log = Logger.getLogger(TimeSheetsUtilitiesImpl.class.getName());
	@Override
	public List<PayslipByEmployee> getPayslipByEmployee(String startDate,String endDate,List<Roster> rosters) {
		// TODO Auto-generated method stub
		List<PayslipByEmployee> listOfPaySlip = new ArrayList<PayslipByEmployee>();
		try{
		
		for(Roster roster:rosters){
			for(LocalDate date = convertDate(startDate); (date.isBefore(convertDate(endDate) )|| date.equals(convertDate(endDate)) );date = date.plusDays(1)){			
				for(RosterTemplate rosterTemplate : roster.getRosterTemplate().stream().filter(distinctByKey(p -> p.getEmployee().getEmployeeEmail())).collect(Collectors.toList())){
					//Finding Employee
					PayslipByEmployee paySliptByEmployee = new PayslipByEmployee();
					paySliptByEmployee.setEmployee(rosterTemplate.getEmployee());
					List<TimeSheets> listOfTiemsheets = new ArrayList<TimeSheets>();
					for(RosterTemplate times:roster.getRosterTemplate().stream().filter(p -> p.getEmployee().getEmployeeEmail().equals(rosterTemplate.getEmployee().getEmployeeEmail())).collect(Collectors.toList())){
						//Finding hours by employee											
						if(date.getDayOfWeek().name().equals(times.getDay())){	
							if(isVildTemplate(roster, times, date)){
							listOfTiemsheets.add(getTimeSheets(roster, times, date));						
							}
						}
					}
					paySliptByEmployee.setTimeSheets(listOfTiemsheets);			
					listOfPaySlip.add(paySliptByEmployee);
				}													
			}			
		}
			
		}catch(Exception exption){
			log.error("something went wrong: " + exption.getStackTrace());
			exption.printStackTrace();
		}
		return listOfPaySlip;
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
		log.info("Day " + date.getDayOfWeek().name());
		log.info("Day " + date.toString());
		log.info("Employee Name " + rosterTemplate.getEmployee().getEmployeeName());
		log.info("Employee Name " + rosterTemplate.getEmployee().getEmployeeCodigo());
		timeSheets.setClient(roster.getClients());
		//timeSheets.setEmployee(rosterTemplate.getEmployee());		
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


	
	
	
	
	

}
