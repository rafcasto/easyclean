package easyclean.admin.model.profiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import easyclean.admin.dto.Clients;
import easyclean.admin.dto.Profiles;
import easyclean.admin.model.portfolio.PortfolioImpl;
import easyclean.admin.model.resttemplate.resttemplateCofiguration;
@Component
@PropertySource("classpath:conf.properties")
public class ProfilesImpl implements ProfilesServices {

	
	@Autowired
	resttemplateCofiguration<Profiles> result;
	@Value("${profile.port}")
	private String servicePort;
	@Value("${service.url}")
	private String serviceURL;
	@Value("${profile.get}")	
	private String profileService;
	@Value("${profile.findall}")
	private String profileServiceFindAll;	
	@Value("${profile.remove}")
	private String removeClient;
	
	static Logger log = Logger.getLogger(ProfilesImpl.class.getName());
	
	private String getURL(String clientsMethod){
	  return  serviceURL+":"+servicePort+"/" + clientsMethod;	
	}
	
	@Override
	public Profiles addProfile(Profiles profile) {
		// TODO Auto-generated method stub
		return  result.getRestTemplatePost(profile, profileService,servicePort);
	}

	@Override
	public List<Profiles> findAll() {
		// TODO Auto-generated method stub
		ResponseEntity<Profiles[]> ClientsList = result.getRestTemplate().getForEntity(getURL(profileServiceFindAll), Profiles[].class);
		ArrayList<Profiles> listOfClientss = new ArrayList<Profiles>(Arrays.asList(ClientsList.getBody()));
		return listOfClientss;
	}

	@Override
	public Profiles findProfile(String id) {
		// TODO Auto-generated method stub
		ResponseEntity<Profiles> clientResponse = null;
		String url = getURL(profileService+id) ;
		try{
			log.info("Calling Service:" + url) ;
			clientResponse = result.getRestTemplate().getForEntity(url, Profiles.class);
			
		}catch(Exception ex){
			log.error("Error on findClient : " + ex.getStackTrace());
		}
				
		return clientResponse.getBody();
	}

	@Override
	public void removeProfile(Profiles profile) {
		// TODO Auto-generated method stub
		result.getRestTemplatePost(profile, removeClient, servicePort);
	}

}
