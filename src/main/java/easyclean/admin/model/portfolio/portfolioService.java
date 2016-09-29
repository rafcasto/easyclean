package easyclean.admin.model.portfolio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import easyclean.admin.dto.Clients;
import easyclean.admin.dto.Employee;

@Service
public interface portfolioService {
	public ArrayList<Clients> findAll();
	public Clients addClients(Clients clientsDto);
	public Clients findClient(String clientID);
	public void removeClient(Clients employeeDTO);
}
