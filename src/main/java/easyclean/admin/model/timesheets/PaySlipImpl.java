package easyclean.admin.model.timesheets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import easyclean.admin.dto.PaySleep;
import easyclean.admin.dto.TimeSheets;
import easyclean.admin.model.resttemplate.resttemplateCofiguration;
@Component
@PropertySource("classpath:conf.properties")
public class PaySlipImpl implements payslipService{

	@Autowired
	resttemplateCofiguration<PaySleep> result;
	@Value("${payslip.port}")
	private String servicePayslip;
	@Value("${service.url}")
	private String serviceURL;
	@Value("${payslip.get}")	
	private String paySlipService;
	@Value("${payslip.findall}")
	private String rosterFindALL;
	
	@Override
	public PaySleep initPaySleep(String PaySleepID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PaySleep> findAll() {
		// TODO Auto-generated method stub
		String restTemplate = serviceURL+":"+servicePayslip+"/" + rosterFindALL;		
		ResponseEntity<PaySleep[]> paySlipList = result.getRestTemplate().getForEntity(restTemplate, PaySleep[].class);
		ArrayList<PaySleep> listOfPayslip = new ArrayList<PaySleep>(Arrays.asList(paySlipList.getBody()));
		return listOfPayslip;
		
	}

	@Override
	public PaySleep addPaySleep(PaySleep PaySleepDto) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return  result.getRestTemplatePost(PaySleepDto, paySlipService,servicePayslip);
		
	}

	@Override
	public List<TimeSheets> addRow(List<TimeSheets> TimeSheets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeSheets> removeRow(List<TimeSheets> TimeSheets, int index) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public PaySleep findPaySlip(String paySlipId) {
		// TODO Auto-generated method stub
		String restTemplate = serviceURL+":"+servicePayslip+"/" +paySlipService  + "/" + paySlipId;		
		ResponseEntity<PaySleep> payslip = result.getRestTemplate().getForEntity(restTemplate, PaySleep.class);		
		return payslip.getBody();
	}


}
