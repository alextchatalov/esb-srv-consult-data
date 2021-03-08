package br.com.bestbank.backbestbank.core;

import br.com.bestbank.backbestbank.core.model.Category;
import br.com.bestbank.backbestbank.core.model.Response;

import java.util.List;

public interface FindLastResponseByCategoryFromActiveParticipantsBoundary {

    List<Response> execute(Category category);
}
