package br.com.consultdata.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Response {

    private Category category;
    private String url;
    private String response;
    private String version;
    private Participant participant;
    @EqualsAndHashCode.Exclude
    private LocalDateTime lastRequest;

}
