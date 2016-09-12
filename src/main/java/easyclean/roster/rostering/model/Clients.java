package easyclean.roster.rostering.model;

import java.util.Date;

public class Clients {
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
	private Date customerStartDate;
	private Date customerEndDate;	
}
