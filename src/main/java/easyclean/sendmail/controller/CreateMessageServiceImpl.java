package easyclean.sendmail.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jboss.logging.Message;
import org.springframework.stereotype.Component;

import easyclean.sendmail.dto.Messages;
import easyclean.sendmail.dto.PayslipByEmployee;
import easyclean.sendmail.dto.TimeSheets;

@Component
public class CreateMessageServiceImpl implements CreateMessageService{


	


	@Override
	public Messages createMessage(PayslipByEmployee employeePaySlip) {
		//Setting Header Information
		Messages message = getMessageHeaderEmail(employeePaySlip);
		message.setMessage(getBodyMessage(employeePaySlip.getTimeSheets()));
		return message;
	}
	
	

	@Override
	public List<Messages> createMessage(List<PayslipByEmployee> listOfPayslips) {
		// TODO Auto-generated method stub
		List<Messages> listMessages = new ArrayList<>();
		for(PayslipByEmployee employeePaySlip: listOfPayslips){
			listMessages.add(createMessage(employeePaySlip));
		}
		return listMessages;
	}

	
	private Messages getMessageHeaderEmail(PayslipByEmployee employeePaySlip){
		Messages message = new Messages();
		message.setFrom("anything@easyclean.appspotmail.com"); //for the momment is hardcoded later will be replace by cleanning company model
		message.setTo(employeePaySlip.getEmployee().getEmployeeEmail());
		message.setEmployee(employeePaySlip.getEmployee());		
		message.setSubject("Payslip From: " + employeePaySlip.getStartDate() + " To: " + employeePaySlip.getEndDate() );		
		return message;
	}
	
	private String getBodyMessage(List<TimeSheets> timeSheets){
		String emailTableBody = "<table style='border-color: #666;' cellpadding='10'>";
		emailTableBody += "<tr  style='background: #eee;'><th>Client</th><th>Date</th><th>Hours</th><th>Pay</th></tr>";		
		for(TimeSheets tmsd : timeSheets){
			emailTableBody += "<tr>";
			emailTableBody += "<td>" +tmsd.getClient().getCustomerName() + "</td>";
			emailTableBody += "<td>" +tmsd.getDay() + "</td>";				
			emailTableBody += "<td>" +tmsd.getHours() + "</td>";				
			emailTableBody += "<td> $ " +tmsd.getTotalHours() + "</td>";
			emailTableBody += "</tr>";
		}
		return emailTableBody;
	}

}
