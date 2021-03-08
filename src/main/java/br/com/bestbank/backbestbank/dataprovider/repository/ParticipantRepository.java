package br.com.bestbank.backbestbank.dataprovider.repository;

import br.com.bestbank.backbestbank.dataprovider.model.ParticipantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<ParticipantEntity, String> {

    ParticipantEntity findByCustomerFriendlyName(String customerFriendlyName);

}
