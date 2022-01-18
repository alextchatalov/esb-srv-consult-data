package br.com.consultdata.dataprovider.repository;

import br.com.consultdata.core.model.Category;
import br.com.consultdata.core.model.ParticipantStatus;
import br.com.consultdata.dataprovider.model.ResponseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResponseRepository extends MongoRepository<ResponseEntity, String> {

    List<ResponseEntity> findByCategoryAndParticipant_status(Category category, ParticipantStatus status);


}
