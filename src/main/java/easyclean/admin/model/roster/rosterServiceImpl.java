package easyclean.admin.model.roster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import easyclean.admin.dto.Employee;
import easyclean.admin.dto.Roster;
import easyclean.admin.dto.RosterTemplate;

import easyclean.admin.model.employee.employeeService;
import easyclean.admin.model.portfolio.portfolioService;
import easyclean.admin.model.resttemplate.resttemplateCofiguration;
@Component
@PropertySource("classpath:conf.properties")
public class rosterServiceImpl implements rosterService{
	@Autowired
	resttemplateCofiguration<Roster> result;
	@Value("${roster.port}")
	private String servicePort;
	@Value("${service.url}")
	private String serviceURL;
	@Value("${roster.get}")	
	private String rosterService;
	@Value("${roster.findall}")
	private String rosterFindALL;
	
	static Logger log = Logger.getLogger(rosterServiceImpl.class.getName());
	
	@Autowired
	employeeService employeeService;
	
	@Autowired
	portfolioService portfolioService;
	

	@Override
	public Roster initRoster(String clientID) {
		// TODO Auto-generated method stub
			return getRoster(clientID);
	}
	
	
	private Roster findRoster(String rosterID){
		ResponseEntity<Roster> rosterResponse = null;
		String url = getURL(rosterService+rosterID) ;
		Roster roster = null;
		try{
			log.info("Calling Service:" + url) ;
			rosterResponse = result.getRestTemplate().getForEntity(url, Roster.class);
			roster = rosterResponse.getBody();
		}catch(Exception ex){
			log.error("Error on findClient : " + ex.getStackTrace());
			
		}
		return roster;
	}
	
	private Roster getRoster(String rosterID){
		
		Roster roster = findRoster(rosterID);
		if(roster == null){
			roster = initRosterPrivate(rosterID);
		}
		return roster;
	}
	
	
	private Roster initRosterPrivate(String rosterID){
		Roster roster = new Roster();
		roster.setId(rosterID);				
		roster.setClients(portfolioService.findClient(rosterID));		
		roster.setRosterTemplate(this.addRow(new ArrayList<RosterTemplate>()));
		return roster;
	}

	
	private RosterTemplate initRosterTemplate(){
		RosterTemplate rosterTemplate = new RosterTemplate();		
		rosterTemplate.setEmployee(new Employee());
		return rosterTemplate;
	}
	
	
	

	
	private String getURL(String clientsMethod){
		  return  serviceURL+":"+servicePort+"/" + clientsMethod;	
		}


	@Override
	public Roster addRoster(Roster rosterDto) {
		// TODO Auto-generated method stub
		
		rosterDto.setClients(portfolioService.findClient(rosterDto.getId()));		
		return  result.getRestTemplatePost(rosterDto, rosterService,servicePort);
	}


	@Override
	public ArrayList<Roster> findAll() {
		// TODO Auto-generated method stub
		String restTemplate = serviceURL+":"+servicePort+"/" + rosterFindALL;
		ResponseEntity<Roster[]> employeeList = result.getRestTemplate().getForEntity(restTemplate, Roster[].class);
		ArrayList<Roster> listOfEmployees = new ArrayList<Roster>(Arrays.asList(employeeList.getBody()));
		return listOfEmployees;
		
	}


	@Override
	public List<RosterTemplate> addRow(List<RosterTemplate> rosterTemplate) {
		// TODO Auto-generated method stub
		rosterTemplate.add(initRosterTemplate());
		return rosterTemplate;
	}


	@Override
	public List<RosterTemplate> removeRow(List<RosterTemplate> rosterTemplate, int index) {
		// TODO Auto-generated method stub
		rosterTemplate.remove(index);
		return rosterTemplate;
	}




}
