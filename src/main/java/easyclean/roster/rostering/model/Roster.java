package easyclean.roster.rostering.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="roster")
public class Roster {
	@Id
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
