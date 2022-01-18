package br.com.consultdata.core;

import br.com.consultdata.core.model.Category;
import br.com.consultdata.core.model.Response;

import java.util.List;

public interface FindLastResponseByCategoryFromActiveParticipantsBoundary {

    List<Response> execute(Category category);
}
