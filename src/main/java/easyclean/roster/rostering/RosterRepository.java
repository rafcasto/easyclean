package easyclean.roster.rostering;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import easyclean.roster.rostering.model.Roster;

public interface RosterRepository extends MongoRepository<Roster, String> {
	@Query(value="{'clients.customerCode' : ?0}")
	public List<Roster> find(String clientCode);
}
