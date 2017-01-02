package easyclean.admin.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MessagesPerPaySlip implements Serializable{
	
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
