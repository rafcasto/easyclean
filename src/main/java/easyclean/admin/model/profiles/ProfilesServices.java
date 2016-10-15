package easyclean.admin.model.profiles;

import java.util.List;

import org.springframework.stereotype.Service;

import easyclean.admin.dto.Profiles;
@Service
public interface ProfilesServices {
	public Profiles addProfile(Profiles profile);
	public 	List<Profiles> findAll();
	public Profiles findProfile(String id);
	public void removeProfile(Profiles profile);
}
