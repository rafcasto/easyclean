package easyclean.sendmail.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

import easyclean.sendmail.dto.Messages;
import easyclean.sendmail.dto.MessagesPerPaySlip;

public interface SendEmialService extends MongoRepository<MessagesPerPaySlip, String>{

}
