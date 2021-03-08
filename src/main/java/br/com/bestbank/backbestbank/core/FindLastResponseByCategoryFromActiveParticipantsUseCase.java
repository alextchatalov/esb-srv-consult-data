package br.com.bestbank.backbestbank.core;

import br.com.bestbank.backbestbank.core.model.Category;
import br.com.bestbank.backbestbank.core.model.Response;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class FindLastResponseByCategoryFromActiveParticipantsUseCase {

    private FindLastResponseByCategoryFromActiveParticipantsBoundary findLastResponseByCategoryFromActiveParticipantsBoundary;

    public List<Response> execute(Category category) {
        return findLastResponseByCategoryFromActiveParticipantsBoundary.execute(category);
    }
}
