package easyclean.admin.model.timesheets;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.admin.dto.PaySleep;
import easyclean.admin.dto.TimeSheets;


@Service
public interface payslipService {

	public PaySleep initPaySleep(String PaySleepID);
	public ArrayList<PaySleep> findAll();
	public PaySleep findPaySlip(String paySlipId);
	public PaySleep addPaySleep(PaySleep PaySleepDto);
	public List<TimeSheets> addRow(List<TimeSheets> TimeSheets);
	public List<TimeSheets> removeRow(List<TimeSheets> TimeSheets,int index);
	
	
	
}
