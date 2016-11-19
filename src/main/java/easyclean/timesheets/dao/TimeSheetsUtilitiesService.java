package easyclean.timesheets.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.timesheets.times.PayslipByEmployee;
import easyclean.timesheets.times.Roster;

@Service
public interface TimeSheetsUtilitiesService {

	public List<PayslipByEmployee> getPayslipByEmployee(String startDate,String endDate,List<Roster> roster);
	
	
}
