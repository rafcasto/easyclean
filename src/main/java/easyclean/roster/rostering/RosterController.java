package easyclean.roster.rostering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import easyclean.roster.rostering.model.Clients;
import easyclean.roster.rostering.model.Roster;

@RestController
@RequestMapping("/roster")
public class RosterController {
	@Autowired
	RosterRepository rosterRepository;
	
	@RequestMapping(method=RequestMethod.POST)
	public Roster create(@RequestBody Roster emp){
		Roster result = rosterRepository.save(emp);
		
		return result;
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="/{rosterId}")
	public Roster get(@PathVariable String rosterID){
		return rosterRepository.findOne(rosterID);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/remove/{rosterId}")
	public void delete(@PathVariable String rosterID){
		 rosterRepository.delete(rosterID);
	}
	
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object[] get(){
		return  rosterRepository.findAll().toArray();
	}
	
	@RequestMapping(value = "/findAll/{customerID}", method = RequestMethod.GET)
	public Object[] getByCustomer(@PathVariable String clientCode){		
		return  rosterRepository.find(clientCode).toArray();
	}
}
