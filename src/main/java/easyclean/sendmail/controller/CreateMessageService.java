package easyclean.sendmail.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.sendmail.dto.Employee;
import easyclean.sendmail.dto.Messages;
import easyclean.sendmail.dto.PaySleep;
import easyclean.sendmail.dto.PayslipByEmployee;

@Service
public interface CreateMessageService {

	
	public Messages createMessage(PayslipByEmployee employeePaySlip);
	public List<Messages> createMessage(List<PayslipByEmployee> listOfPayslips);
}
