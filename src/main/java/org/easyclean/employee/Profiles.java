package org.easyclean.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="profiles")
public class Profiles {
	@Id
	private String id;
	private double salaryPerHour;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSalaryPerHour() {
		return salaryPerHour;
	}
	public void setSalaryPerHour(double salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	public double getIrdPersantage() {
		return irdPersantage;
	}
	public void setIrdPersantage(double irdPersantage) {
		this.irdPersantage = irdPersantage;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	private double irdPersantage;
	private double anualLeave;
	public double getAnualLeave() {
		return anualLeave;
	}
	public void setAnualLeave(double anualLeave) {
		this.anualLeave = anualLeave;
	}
	private String profileName;
}
