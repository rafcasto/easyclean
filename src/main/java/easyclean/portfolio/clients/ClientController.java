package easyclean.portfolio.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
public class ClientController {

	@Autowired
	ClientRepository clients;
	
	@RequestMapping(method=RequestMethod.POST)
	public Clients create(@RequestBody Clients client){
		Clients result = clients.save(client);		
		return result;
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="/{clientId}")
	public Clients get(@PathVariable String clientId){
		return clients.findOne(clientId);
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object[] get(){
		return  clients.findAll().toArray();
	}
	
}
