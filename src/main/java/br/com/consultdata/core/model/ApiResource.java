package br.com.consultdata.core.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@EqualsAndHashCode
public class ApiResource {

    private String apiFamilyType;
    private String apiVersion;
    @Builder.Default
    private List<String> apiEndpoint = new ArrayList<>();
}
