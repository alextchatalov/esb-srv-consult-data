package br.com.bestbank.getdataopenbanking.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeesPersonalAccounts {
    private List<PriorityService> priorityServices;
    private List<OtherService> otherServices;
}
