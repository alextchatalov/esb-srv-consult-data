package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.core.model.ApiResource;
import br.com.bestbank.getdataopenbanking.core.model.Participant;
import br.com.bestbank.getdataopenbanking.core.model.ParticipantStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ParticipantFixute {

    static Participant validParticipant() {
        final ApiResource discovery = ApiResource.builder().apiFamilyType("discovery").apiVersion("1").apiEndpoint(Arrays.asList("https://api.bradesco.com/open-banking/discovery/v1")).build();
        final ApiResource channels = ApiResource.builder().apiFamilyType("channels").apiVersion("1").apiEndpoint(Arrays.asList("https://api.bradesco.com/bradesco/open-banking/channels/v1")).build();
        final ApiResource services = ApiResource.builder().apiFamilyType("products-services").apiVersion("1").apiEndpoint(Arrays.asList("https://api.bradesco.com/bradesco/open-banking/products-services/v1")).build();

        final List<ApiResource> apis = new ArrayList<>();
        apis.add(discovery);
        apis.add(channels);
        apis.add(services);

        final Participant participantMock = Participant.builder().organisationId("\"a72a6d4f-79be-5362-afb6-f8d9c9c39cf5\"").organisationName("\"BCO BRADESCO S.A.\"").customerFriendlyName("Banco Bradesco").status(ParticipantStatus.ACTIVE).apiResources(apis).build();
        return participantMock;
    }

    static Participant participantWithOutOrgDomainClaims() {
        final ApiResource discovery = ApiResource.builder().apiFamilyType("discovery").apiVersion("1").apiEndpoint(Arrays.asList("https://api.bradesco.com/open-banking/discovery/v1")).build();
        final ApiResource channels = ApiResource.builder().apiFamilyType("channels").apiVersion("1").apiEndpoint(Arrays.asList("https://api.bradesco.com/bradesco/open-banking/channels/v1")).build();
        final ApiResource services = ApiResource.builder().apiFamilyType("products-services").apiVersion("1").apiEndpoint(Arrays.asList("https://api.bradesco.com/bradesco/open-banking/products-services/v1")).build();

        final List<ApiResource> apis = new ArrayList<>();
        apis.add(discovery);
        apis.add(channels);
        apis.add(services);

        final Participant participantMock = Participant.builder().organisationId("\"a72a6d4f-79be-5362-afb6-f8d9c9c39cf5\"").organisationName("\"BCO BRADESCO S.A.\"").customerFriendlyName("Banco Bradesco").status(ParticipantStatus.INACTIVE).apiResources(apis).build();
        return participantMock;
    }
}
