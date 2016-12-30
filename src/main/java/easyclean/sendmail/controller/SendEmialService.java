package easyclean.sendmail.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

import easyclean.sendmail.dto.Messages;

public interface SendEmialService extends MongoRepository<Messages, String>{

}
