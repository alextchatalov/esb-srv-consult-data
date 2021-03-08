package br.com.bestbank.backbestbank.dataprovider.model;

import br.com.bestbank.backbestbank.core.model.Response;

import java.util.List;
import java.util.stream.Collectors;

public interface ResponseConverter {

    static ResponseEntity responseToResponseEntity(Response response) {
        return ResponseEntity.builder()
                .participant(ParticipantConverter.participantToParticipantEntity(response.getParticipant()))
                .url(response.getUrl())
                .category(response.getCategory())
                .lastRequest(response.getLastRequest())
                .response(response.getResponse())
                .version(response.getVersion())
                .build();
    }

    static Response responseEntityToResponse(ResponseEntity responseEntity) {
        return Response.builder()
                .participant(ParticipantConverter.participantEntityToParticipant(responseEntity.getParticipant()))
                .url(responseEntity.getUrl())
                .category(responseEntity.getCategory())
                .lastRequest(responseEntity.getLastRequest())
                .response(responseEntity.getResponse())
                .version(responseEntity.getVersion())
                .build();
    }

    static List<Response> listOfResponseEntityToListOfResponse(List<ResponseEntity> responseEntities) {
        return responseEntities.stream().map(responseEntity -> responseEntityToResponse(responseEntity)).collect(Collectors.toList());
    }
}
