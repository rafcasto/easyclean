package easyclean.portfolio.clients;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Clients, String>{

}
