package easyclean.admin.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clients implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -3260181170942839074L;
	private String id;
	
	private String companyCode;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String customerName;
	private String customerCode;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerPointOfContactName() {
		return customerPointOfContactName;
	}
	public void setCustomerPointOfContactName(String customerPointOfContactName) {
		this.customerPointOfContactName = customerPointOfContactName;
	}
	public String getCustomerPointOfContactNumber() {
		return customerPointOfContactNumber;
	}
	public void setCustomerPointOfContactNumber(String customerPointOfContactNumber) {
		this.customerPointOfContactNumber = customerPointOfContactNumber;
	}
	public String getCustomerPointOfContactEmail() {
		return customerPointOfContactEmail;
	}
	public void setCustomerPointOfContactEmail(String customerPointOfContactEmail) {
		this.customerPointOfContactEmail = customerPointOfContactEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public boolean isCustomerIsActive() {
		return customerIsActive;
	}
	public void setCustomerIsActive(boolean customerIsActive) {
		this.customerIsActive = customerIsActive;
	}
	public Date getCustomerStartDate() {
		return customerStartDate;
	}
	public void setCustomerStartDate(Date customerStartDate) {
		this.customerStartDate = customerStartDate;
	}
	public Date getCustomerEndDate() {
		return customerEndDate;
	}
	public void setCustomerEndDate(Date customerEndDate) {
		this.customerEndDate = customerEndDate;
	}
	private String customerPointOfContactName;
	private String customerPointOfContactNumber;
	private String customerPointOfContactEmail;
	private String customerAddress;
	private boolean customerIsActive;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date customerStartDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date customerEndDate;	
}
