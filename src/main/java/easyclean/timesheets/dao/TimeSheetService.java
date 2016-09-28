package easyclean.timesheets.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import easyclean.timesheets.times.PaySleep;

public interface TimeSheetService extends MongoRepository<PaySleep, String>{

	
}
