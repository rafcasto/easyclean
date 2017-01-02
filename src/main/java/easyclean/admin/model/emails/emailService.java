package easyclean.admin.model.emails;

import org.springframework.stereotype.Service;

import easyclean.admin.dto.MessagesPerPaySlip;
import easyclean.admin.dto.PaySleep;

@Service
public interface emailService {

	public void sendEmails(PaySleep paySleep);
}
