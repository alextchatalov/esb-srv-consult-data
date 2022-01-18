package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.dataprovider.model.ParticipantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<ParticipantEntity, String> {

    ParticipantEntity findByCustomerFriendlyName(String customerFriendlyName);

}
