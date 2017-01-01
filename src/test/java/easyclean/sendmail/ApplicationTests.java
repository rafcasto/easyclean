package easyclean.sendmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import easyclean.sendmail.controller.CreateMessageService;
import easyclean.sendmail.controller.SendMessageUtilService;
import easyclean.sendmail.dto.Clients;
import easyclean.sendmail.dto.Employee;
import easyclean.sendmail.dto.Messages;
import easyclean.sendmail.dto.PaySleep;
import easyclean.sendmail.dto.PayslipByEmployee;
import easyclean.sendmail.dto.Profiles;
import easyclean.sendmail.dto.Roster;
import easyclean.sendmail.dto.RosterTemplate;
import easyclean.sendmail.dto.TimeSheets;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private CreateMessageService message; 
	
	@Autowired 
	SendMessageUtilService sendMessage;
	
	private PaySleep paySlip = new PaySleep();
	
	
	private Messages ms = new Messages();
	
	private List<Roster> getRoster(){
		 List<Roster> rosterlist = new ArrayList<Roster>();
		 Roster a = new Roster();
		 a.setClients(getClient1());
		 RosterTemplate tmpl = new RosterTemplate();
		 tmpl.setEmployee(getEmployee1());
		 List<RosterTemplate> templs = new ArrayList<>();
		 templs.add(tmpl);
		 a.setRosterTemplate(templs);
		 rosterlist.add(new Roster());
		 return rosterlist;
	}
	
	private Profiles getProfile(){
		Profiles pr = new Profiles();
		pr.setProfileName("Cleanner");
		pr.setSalaryPerHour(15.50);
		return pr;
	}
	
	private Employee getEmployee1(){
		Employee emp = new Employee();
		emp.setEmployeeEmail("rafcasto@gmail.com");
		emp.setEmployeeName("Rafael");
		emp.setEmployeeLastName("Castillo");
		emp.setFullName("Rafael Castillo");
		emp.setEmployeePhone("02108765733");
		emp.setCompanyCode("EMP0001");
		emp.setEmployeeIRD("111111111111");
		emp.setEmployeeCodigo("EMP00001");
		emp.setProfile(this.getProfile());
		return emp;
	}
	
	private Employee getEmployee2(){
		Employee emp = new Employee();
		emp.setEmployeeEmail("ante_c2@hotmail.com");
		emp.setEmployeeName("Gerardo");
		emp.setEmployeeLastName("Castillo");
		emp.setFullName("Gerardo Castillo");
		emp.setEmployeePhone("02108765733");
		emp.setCompanyCode("EMP0001");
		emp.setEmployeeIRD("111111111111");
		emp.setEmployeeCodigo("EMP00002");
		emp.setProfile(this.getProfile());
		return emp;
	}
	
	private Clients getClient1(){
		Clients cl = new Clients();
		cl.setCompanyCode("EMP0001");
		cl.setCustomerName("NTEC");
		return cl;
	}

	private Clients getClient2(){
		Clients cl = new Clients();
		cl.setCompanyCode("EMP0001");
		cl.setCustomerName("DATACOM");
		return cl;
	}
	
	private TimeSheets getTimeSheetsEmp(String day,String startTime,String endTime,Double hours,Double totalHours,Clients client,Employee employee){
		TimeSheets timeSheets = new TimeSheets();
		timeSheets.setCompanyCod("EMP0001");
		timeSheets.setDay(day);
		timeSheets.setStartTime(startTime);
		timeSheets.setEndTime(endTime);
		timeSheets.setHours(hours);
		timeSheets.setTotalHours(totalHours);
		timeSheets.setClient(client);
		timeSheets.setEmployee(employee);
		return timeSheets;
	}
	
	private List<TimeSheets> getTimeSheets(){
		List<TimeSheets> timeSheets = new ArrayList<>();
		timeSheets.add(this.getTimeSheetsEmp("2016-01-04", "12:00", "14:00", 2.0, 31.0, getClient1(), getEmployee1()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-05", "12:00", "13:00", 1.0, 15.5, getClient1(), getEmployee1()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-06", "12:00", "13:00", 1.0, 15.5, getClient1(), getEmployee2()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-06", "12:00", "13:00", 1.0, 15.5, getClient1(), getEmployee1()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-07", "12:00", "13:00", 1.0, 15.5, getClient2(), getEmployee1()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-05", "12:00", "13:00", 1.0, 15.5, getClient1(), getEmployee2()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-08", "12:00", "13:00", 1.0, 15.5, getClient2(), getEmployee1()));		
		timeSheets.add(this.getTimeSheetsEmp("2016-01-04", "12:00", "13:00", 1.0, 15.5, getClient1(), getEmployee2()));				
		timeSheets.add(this.getTimeSheetsEmp("2016-01-07", "12:00", "13:00", 1.0, 15.5, getClient2(), getEmployee2()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-08", "12:00", "13:00", 1.0, 15.5, getClient2(), getEmployee2()));
		timeSheets.add(this.getTimeSheetsEmp("2016-01-09", "12:00", "14:00", 2.0, 31.0, getClient1(), getEmployee2()));
		return timeSheets;
	}
	
	private List<PayslipByEmployee> getPaySlipByEmployee(PaySleep payslip){
		List<PayslipByEmployee> listOfPaySlip = new ArrayList<>();
		for(TimeSheets tm : payslip.getTimeSheets().stream().filter(distinctByKey(p -> p.getEmployee().getEmployeeEmail())).collect(Collectors.toList())){
			PayslipByEmployee paySlipByEmployee = new PayslipByEmployee();
			paySlipByEmployee.setEmployee(tm.getEmployee());
			paySlipByEmployee.setStartDate(payslip.getStartDate());
			paySlipByEmployee.setEndDate(payslip.getEndDate());
			paySlipByEmployee.setTimeSheets(payslip.getTimeSheets().stream().filter(p -> p.getEmployee().getEmployeeEmail().equals(tm.getEmployee().getEmployeeEmail())).collect(Collectors.toList()));
			listOfPaySlip.add(paySlipByEmployee);
		}
		return listOfPaySlip; 
				
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	public void beforeTest(){		 						
		paySlip.setCompanyCode("EMP00001");
		paySlip.setStartDate("2016-01-01");
		paySlip.setEndDate("2016-01-15");	
		paySlip.setTimeSheets(this.getTimeSheets());
		paySlip.setRosters(getRoster());
		paySlip.setPaysliptPerEmployee(getPaySlipByEmployee(paySlip));
		
	}
	
	@Test
	public void testMultipleMessage() {
		this.beforeTest();
		Assert.assertNotNull(message.createMessage(paySlip.getPaysliptPerEmployee()));		
		for(Messages ms : message.createMessage(paySlip.getPaysliptPerEmployee())){
			sendMessage.sendMessage(ms);
			printMessage(ms);
		}
	}
	
	private void printMessage(Messages ms){
		System.out.println("From : " +   ms.getFrom());
		System.out.println("To : " +   ms.getTo());
		System.out.println("Subject : " +   ms.getSubject());
		System.out.println("Body : " +   ms.getMessage());
	}
	
	
	
	
	@Test
	public void testOneMessageAtTheTime(){
		this.beforeTest();
		for(PayslipByEmployee paySlipByEmployee : paySlip.getPaysliptPerEmployee()){
			Assert.assertNotNull(message.createMessage(paySlipByEmployee));
			printMessage(message.createMessage(paySlipByEmployee));
		}
	}
	
	
	
	
	

}
