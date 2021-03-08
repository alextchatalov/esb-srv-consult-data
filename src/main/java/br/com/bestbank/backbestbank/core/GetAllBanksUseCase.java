package br.com.bestbank.backbestbank.core;

import br.com.bestbank.backbestbank.core.model.Category;
import br.com.bestbank.backbestbank.core.model.Response;
import br.com.bestbank.backbestbank.core.model.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class GetAllBanksUseCase {

    private final FindLastResponseByCategoryFromActiveParticipantsUseCase findLastResponseByCategoryFromActiveParticipantsUseCase;

    public List<Root> execute(Category category) {

        List<Response> responses = findLastResponseByCategoryFromActiveParticipantsUseCase.execute(category);

        ObjectMapper om = new ObjectMapper();
        List<Root> roots = new ArrayList<>();
        for (Response response : responses) {
            try {
                Root root = om.readValue(response.getResponse(), Root.class);
                roots.add(root);
            } catch (JsonProcessingException e) {
                log.error("Can not convert response to root class: " + e.getMessage());
            }
        }
        return roots;
    }

}
