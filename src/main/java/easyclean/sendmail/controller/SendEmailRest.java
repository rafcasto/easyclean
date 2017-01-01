package easyclean.sendmail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import easyclean.sendmail.dto.Messages;
import easyclean.sendmail.dto.MessagesPerPaySlip;
import easyclean.sendmail.dto.PaySleep;

@RestController
@RequestMapping("/sendemail")
public class SendEmailRest {

	@Autowired
	CreateMessageService createEmail;
	
	@Autowired
	SendMessageUtilService sendMessage;
	
	@Autowired
	SendEmialService sendEmailServiceLogs;
	
	@RequestMapping(method=RequestMethod.POST)
	public MessagesPerPaySlip create(@RequestBody PaySleep paySlip){		
		MessagesPerPaySlip messagePerPaySlip = new MessagesPerPaySlip();		
		messagePerPaySlip.setPaySlip(paySlip);
		messagePerPaySlip.setListOfMessages(sendMessages(paySlip));
		sendEmailServiceLogs.save(messagePerPaySlip);
		return messagePerPaySlip;
		
	}
	
	
	private List<Messages> sendMessages(PaySleep paySlip){
		List<Messages> messages = new ArrayList<>();
		for(Messages ms : createEmail.createMessage(paySlip.getPaysliptPerEmployee())){			
			sendMessage.sendMessage(ms);
			messages.add(ms);			
		}
		return messages;
	}
	
}
