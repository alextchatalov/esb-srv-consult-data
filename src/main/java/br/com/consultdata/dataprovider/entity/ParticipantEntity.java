package br.com.bestbank.getdataopenbanking.dataprovider.entity;

import br.com.bestbank.getdataopenbanking.core.model.ParticipantStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "participant")
@Builder
@Getter
@EqualsAndHashCode
public class ParticipantEntity {

    @Id
    private String organisationId;
    private ParticipantStatus status;
    private String organisationName;
    private String customerFriendlyName;
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private List<ApiResourceEntity> apiResources = new ArrayList<>();
}
