package br.com.consultdata.dataprovider;

import br.com.consultdata.core.FindLastResponseByCategoryFromActiveParticipantsBoundary;
import br.com.consultdata.core.model.Category;
import br.com.consultdata.core.model.ParticipantStatus;
import br.com.consultdata.core.model.Response;
import br.com.consultdata.dataprovider.model.ResponseConverter;
import br.com.consultdata.dataprovider.model.ResponseEntity;
import br.com.consultdata.dataprovider.repository.ResponseRepository;
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
