package br.com.bestbank.getdataopenbanking.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Participant {

    private String organisationId;
    private ParticipantStatus status;
    private String organisationName;
    private String customerFriendlyName;
    @Builder.Default
    private List<ApiResource> apiResources = new ArrayList<>();
}
