package easyclean.admin.model.roster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.admin.dto.Employee;
import easyclean.admin.dto.Roster;
import easyclean.admin.dto.RosterTemplate;
@Service
public interface rosterService {
	public Roster initRoster(String rosterID);
	public ArrayList<Roster> findAll();
	public Roster addRoster(Roster rosterDto);
	public List<RosterTemplate> addRow(List<RosterTemplate> rosterTemplate);
	public List<RosterTemplate> removeRow(List<RosterTemplate> rosterTemplate,int index);
	
}
