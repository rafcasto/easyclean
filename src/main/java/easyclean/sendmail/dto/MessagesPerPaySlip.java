package easyclean.sendmail.dto;

import java.util.List;

import org.springframework.data.annotation.Id;

public class MessagesPerPaySlip {
	@Id
	private String id;
	private PaySleep paySlip;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PaySleep getPaySlip() {
		return paySlip;
	}
	public void setPaySlip(PaySleep paySlip) {
		this.paySlip = paySlip;
	}
	public List<Messages> getListOfMessages() {
		return listOfMessages;
	}
	public void setListOfMessages(List<Messages> listOfMessages) {
		this.listOfMessages = listOfMessages;
	}
	private List<Messages> listOfMessages;
}
