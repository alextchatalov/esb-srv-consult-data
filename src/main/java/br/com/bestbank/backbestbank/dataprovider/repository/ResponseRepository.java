package br.com.bestbank.backbestbank.dataprovider.repository;

import br.com.bestbank.backbestbank.core.model.Category;
import br.com.bestbank.backbestbank.core.model.ParticipantStatus;
import br.com.bestbank.backbestbank.dataprovider.model.ResponseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResponseRepository extends MongoRepository<ResponseEntity, String> {

    List<ResponseEntity> findByCategoryAndParticipant_status(Category category, ParticipantStatus status);


}
