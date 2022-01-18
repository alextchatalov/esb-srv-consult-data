package br.com.consultdata.dataprovider.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "apiResource")
@Builder
@Getter
public class ApiResourceEntity {

    private String apiFamilyType;
    private String apiVersion;
    private List<String> apiEndpoint = new ArrayList<>();
}
