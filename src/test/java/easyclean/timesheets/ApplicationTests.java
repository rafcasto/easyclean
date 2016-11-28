package easyclean.timesheets;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import easyclean.timesheets.dao.TimeSheetsUtilitiesService;
import easyclean.timesheets.times.Clients;
import easyclean.timesheets.times.Employee;
import easyclean.timesheets.times.PayslipByEmployee;
import easyclean.timesheets.times.Profiles;
import easyclean.timesheets.times.Roster;
import easyclean.timesheets.times.RosterTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private String testStartDate = "2016-09-13";
	private String testEndDate = "2016-09-20";
	
	
	
	private Roster getRoster(){
		Roster roster = new Roster();		
		Clients client = new Clients();
		client.setCompanyCode("TESTCOMPANYCODE");
		client.setCustomerCode("CUSTOMERCODE");
		client.setCustomerName("TESTCUSTOMERNAME");
		roster.setClients(client);
		List<RosterTemplate> rosterTemplateList = new ArrayList<RosterTemplate>();						
		rosterTemplateList.add(getRosterTempalte("MONDAY",3.0));
		rosterTemplateList.add(getRosterTempalte("WEDNESDAY",2.0));
		rosterTemplateList.add(getRosterTempalte("TUESDAY",5.0));		
		roster.setRosterTemplate(rosterTemplateList);
		return roster;
	}
	
	private RosterTemplate getRosterTempalte(String day,double hours){
		RosterTemplate rosterTemplate = new RosterTemplate();
		Profiles profile = new Profiles();
		profile.setProfileName("Cleanner");
		profile.setSalaryPerHour(15.5);
		Employee employee = new Employee();
		employee.setCompanyCode("TESTCOMPANYCODE");
		employee.setEmployeeCodigo("EmployeeCodigo");
		employee.setEmployeeName("TESTEMPLOYEENAME");
		employee.setEmployeeEmail("rafaelc@gmail.com");
		employee.setProfile(profile);
		rosterTemplate.setDay(day);
		
		rosterTemplate.setTotalHours(hours);
		rosterTemplate.setEmployee(employee);
		return rosterTemplate;
	}
	
	@Autowired
	TimeSheetsUtilitiesService timeSheetsUtilities;
	
	
	
	@Test
	public void success() {		
		List<Roster> rosters = new ArrayList<Roster>();
		rosters.add(getRoster());
		rosters.add(getRoster());
		for(PayslipByEmployee ps : timeSheetsUtilities.getPayslipByEmployee(testStartDate, testEndDate, rosters)){
			System.out.println(ps.getEmployee().getEmployeeEmail());
			
		}
		Assert.notEmpty(timeSheetsUtilities.getPayslipByEmployee(testStartDate, testEndDate, rosters));
	}
	
//	@Test
//	public void fail() {
//		List<Roster> rosters = new ArrayList<Roster>();
//		Assert.notEmpty(timeSheetsUtilities.getTimeSheet(testStartDate, testEndDate, rosters));
//	}

}
