package easyclean.admin.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Roster implements Serializable{
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private Clients clients;
	public Clients getClients() {
		return clients;
	}
	public void setClients(Clients clients) {
		this.clients = clients;
	}
	
	List<RosterTemplate> rosterTemplate;
	public List<RosterTemplate> getRosterTemplate() {
		return rosterTemplate;
	}
	public void setRosterTemplate(List<RosterTemplate> rosterTemplate) {
		this.rosterTemplate = rosterTemplate;
	}
}
