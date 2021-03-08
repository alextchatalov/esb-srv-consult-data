package br.com.bestbank.backbestbank.dataprovider.model;

import br.com.bestbank.backbestbank.core.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "response")
@Builder
@Getter
@AllArgsConstructor
public class ResponseEntity {

    private Category category;
    private String url;
    private String response;
    private String version;
    private ParticipantEntity participant;
    @EqualsAndHashCode.Exclude
    private LocalDateTime lastRequest;
}
