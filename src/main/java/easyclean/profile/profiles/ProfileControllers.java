package easyclean.profile.profiles;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileControllers {

	Logger log = Logger.getLogger(ProfileControllers.class.getName());
	
	@Autowired
	ProfilesRepository profile; 
	
	@RequestMapping(method=RequestMethod.POST)
	public Profiles create(@RequestBody Profiles profiledto){
		Profiles result = profile.save(profiledto);		
		return result;
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/{profileId}")
	public Profiles get(@PathVariable String profileId){
		return profile.findOne(profileId);
	}
	
	@RequestMapping(method= RequestMethod.POST,value="/remove")
	public void remove(@RequestBody Profiles profiledto){
		profile.delete(profiledto);
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object[] get(){
		return  profile.findAll().toArray();
	}
	
}
