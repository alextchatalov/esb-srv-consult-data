package br.com.bestbank.backbestbank.dataprovider.model;

import br.com.bestbank.backbestbank.core.model.Participant;

import java.util.List;
import java.util.stream.Collectors;

public interface ParticipantConverter {

    static ParticipantEntity participantToParticipantEntity(Participant participant) {
        return ParticipantEntity.builder()
                .organisationId(participant.getOrganisationId())
                .status(participant.getStatus())
                .organisationName(participant.getOrganisationName())
                .customerFriendlyName(participant.getCustomerFriendlyName())
                .apiResources(ApiResourceConverter.apiResourceToApiResourceEntity(participant.getApiResources()))
                .build();
    }

    static Participant participantEntityToParticipant(ParticipantEntity participantEntity) {
        return Participant.builder()
                .organisationId(participantEntity.getOrganisationId())
                .status(participantEntity.getStatus())
                .organisationName(participantEntity.getOrganisationName())
                .customerFriendlyName(participantEntity.getCustomerFriendlyName())
                .apiResources(ApiResourceConverter.apiResourceEntityToApiResource(participantEntity.getApiResources()))
                .build();
    }

    static List<Participant> listOfParticipantEntityToListOfParticipant(List<ParticipantEntity> participantsEntity) {
        return participantsEntity.stream().map(participantEntity -> participantEntityToParticipant(participantEntity)).collect(Collectors.toList());
    }
}
