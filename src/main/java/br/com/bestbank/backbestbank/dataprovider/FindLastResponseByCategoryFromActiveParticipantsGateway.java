package br.com.bestbank.backbestbank.dataprovider;

import br.com.bestbank.backbestbank.core.FindLastResponseByCategoryFromActiveParticipantsBoundary;
import br.com.bestbank.backbestbank.core.model.Category;
import br.com.bestbank.backbestbank.core.model.ParticipantStatus;
import br.com.bestbank.backbestbank.core.model.Response;
import br.com.bestbank.backbestbank.dataprovider.model.ResponseConverter;
import br.com.bestbank.backbestbank.dataprovider.model.ResponseEntity;
import br.com.bestbank.backbestbank.dataprovider.repository.ResponseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class FindLastResponseByCategoryFromActiveParticipantsGateway implements FindLastResponseByCategoryFromActiveParticipantsBoundary {

    @Autowired
    ResponseRepository repository;

    @Override
    public List<Response> execute(Category category) {
        List<ResponseEntity> responses = repository.findByCategoryAndParticipant_status(category, ParticipantStatus.ACTIVE);
            return ResponseConverter.listOfResponseEntityToListOfResponse(responses);
    }
}
