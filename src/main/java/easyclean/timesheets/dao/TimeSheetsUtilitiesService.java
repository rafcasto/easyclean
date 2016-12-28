package easyclean.timesheets.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.timesheets.times.PaySleep;
import easyclean.timesheets.times.PayslipByEmployee;
import easyclean.timesheets.times.Roster;
import easyclean.timesheets.times.TimeSheets;

@Service
public interface TimeSheetsUtilitiesService {

	public List<TimeSheets> getTimeSheet(String startDate,String endDate,List<Roster> roster);
	public List<PayslipByEmployee> getPayslipByEmployee(PaySleep payslip);
	
}
