package easyclean.admin.model.portfolio;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import easyclean.admin.controller.AdminRosterPage;
import easyclean.admin.dto.Clients;
import easyclean.admin.model.resttemplate.resttemplateCofiguration;
@Component
@PropertySource("classpath:conf.properties")
public class PortfolioImpl implements portfolioService{
	@Autowired
	resttemplateCofiguration<Clients> result;
	@Value("${portfolio.port}")
	private String servicePort;
	@Value("${service.url}")
	private String serviceURL;
	@Value("${portfolio.get}")	
	private String ClientsService;
	@Value("${portfolio.findall}")
	private String ClientsFindALL;	
	@Value("${portfolio.remove}")
	private String removeClient;
	
	static Logger log = Logger.getLogger(PortfolioImpl.class.getName());
	
	private String getURL(String clientsMethod){
	  return  serviceURL+":"+servicePort+"/" + clientsMethod;	
	}
	
	@Override
	public ArrayList<Clients> findAll() {
		// TODO Auto-generated method stub
			
		ResponseEntity<Clients[]> ClientsList = result.getRestTemplate().getForEntity(getURL(ClientsFindALL), Clients[].class);
		ArrayList<Clients> listOfClientss = new ArrayList<Clients>(Arrays.asList(ClientsList.getBody()));
		return listOfClientss;
	}

	@Override
	public Clients addClients(Clients clientsDTO) {
		// TODO Auto-generated method stub		
		return  result.getRestTemplatePost(clientsDTO, ClientsService,servicePort);
	}

	@Override
	public Clients findClient(String clientID) {
		// TODO Auto-generated method stub
		ResponseEntity<Clients> clientResponse = null;
		String url = getURL(ClientsService+clientID) ;
		try{
			log.info("Calling Service:" + url) ;
			clientResponse = result.getRestTemplate().getForEntity(url, Clients.class);
			
		}catch(Exception ex){
			log.error("Error on findClient : " + ex.getStackTrace());
		}
				
		return clientResponse.getBody();
	}

	@Override
	public void removeClient(Clients clients) {
		// TODO Auto-generated method stub
		result.getRestTemplatePost(clients, removeClient, servicePort);
	}

}
