package easyclean.timesheets.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import easyclean.timesheets.times.PaySleep;

@RestController
@RequestMapping("/timesheets")
public class TimeSheetsController {
	@Autowired
	TimeSheetService timesheetService;
	
	
	@Autowired
	TimeSheetsUtilitiesService utils;

	@RequestMapping(method=RequestMethod.POST)
	public PaySleep create(@RequestBody PaySleep paysleep){
		paysleep.setTimeSheets(utils.getTimeSheet(paysleep.getStartDate(), paysleep.getEndDate(), paysleep.getRosters()));
		paysleep.setPaysliptPerEmployee(utils.getPayslipByEmployee(paysleep));		
		PaySleep paysleepResult = timesheetService.save(paysleep);		
		return paysleepResult;
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="/{rosterId}")
	public PaySleep get(@PathVariable String rosterId){
		return timesheetService.findOne(rosterId);
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object[] get(){
		return  timesheetService.findAll().toArray();
	}
	
	
	
}
