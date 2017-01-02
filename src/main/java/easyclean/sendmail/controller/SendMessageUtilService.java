package easyclean.sendmail.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.sendmail.dto.Messages;
@Service
public interface SendMessageUtilService {
	public void sendMessage(Messages message);
	public void sendMessage(List<Messages> listOfMessages);
}
