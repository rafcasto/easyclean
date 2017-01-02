package easyclean.admin.model.emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import easyclean.admin.dto.MessagesPerPaySlip;
import easyclean.admin.dto.PaySleep;
import easyclean.admin.model.resttemplate.resttemplateCofiguration;

@Component
@PropertySource("classpath:conf.properties")
public class EmailsServiceImpl implements emailService{

	@Autowired
	resttemplateCofiguration<MessagesPerPaySlip> result;
	@Value("${sendemail.port}")
	private String servicePort;
	@Value("${service.url}")
	private String serviceURL;
	@Value("${sendemail}")	
	private String serviceName;
	
	
	@Override
	public void sendEmails(PaySleep paySleep) {
		// TODO Auto-generated method stub
		MessagesPerPaySlip messagesPerPaySlip = new MessagesPerPaySlip();
		messagesPerPaySlip.setPaySlip(paySleep);
		result.getRestTemplatePost(messagesPerPaySlip, serviceName,servicePort);
	}

}
