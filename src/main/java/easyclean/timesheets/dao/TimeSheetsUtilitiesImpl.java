package easyclean.timesheets.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import easyclean.timesheets.times.PaySleep;
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
		double total = 0.0;
		for(Roster roster:rosters){
			for(LocalDate date = convertDate(startDate); (date.isBefore(convertDate(endDate) )|| date.equals(convertDate(endDate)) );date = date.plusDays(1)){			
				for(RosterTemplate rosterTemplate : roster.getRosterTemplate()){
					if(date.getDayOfWeek().name().equals(rosterTemplate.getDay())){	
						if(isVildTemplate(roster, rosterTemplate, date)){
						listOfTiemsheets.add(getTimeSheets(roster, rosterTemplate, date));
						total = total + rosterTemplate.getTotalHours();
						}
					}
				}									
			}			
		}
		
		log.info("total hours " + total);
		}catch(Exception exption){
			log.error("something went wrong: " + exption.getStackTrace());
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
		log.info("Day " + date.getDayOfWeek().name());
		log.info("Day " + date.toString());
		log.info("Employee Name " + rosterTemplate.getEmployee().getEmployeeName());
		log.info("Employee Name " + rosterTemplate.getEmployee().getEmployeeCodigo());
		timeSheets.setClient(roster.getClients());
		timeSheets.setEmployee(rosterTemplate.getEmployee());		
		timeSheets.setStartTime(rosterTemplate.getStartTime());
		timeSheets.setEndTime(rosterTemplate.getEndTime());		
		timeSheets.setDay(date.toString());
		timeSheets.setHours(rosterTemplate.getTotalHours());
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

	
	
	

}
