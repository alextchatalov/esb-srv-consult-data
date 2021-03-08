package br.com.bestbank.backbestbank.dataprovider.model;

import br.com.bestbank.backbestbank.core.model.ApiResource;

import java.util.List;
import java.util.stream.Collectors;

public interface ApiResourceConverter {

    static List<ApiResourceEntity> apiResourceToApiResourceEntity(List<ApiResource> apiResources) {

        return apiResources.stream().map(apiResource ->
                ApiResourceEntity.builder()
                        .apiFamilyType(apiResource.getApiFamilyType())
                        .apiVersion(apiResource.getApiVersion())
                        .apiEndpoint(apiResource.getApiEndpoint())
                        .build()
        ).collect(Collectors.toList());
    }

    static List<ApiResource> apiResourceEntityToApiResource(List<ApiResourceEntity> apiResourceEntities) {

        return apiResourceEntities.stream().map(apiResourceEntity ->
                ApiResource.builder()
                        .apiFamilyType(apiResourceEntity.getApiFamilyType())
                        .apiVersion(apiResourceEntity.getApiVersion())
                        .apiEndpoint(apiResourceEntity.getApiEndpoint())
                        .build()
        ).collect(Collectors.toList());
    }
}
