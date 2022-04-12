package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "api_resource")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class ApiResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String apiFamilyType;
    private String apiVersion;
    @OneToMany(mappedBy = "apiResource", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Setter
    private List<ApiEndPointEntity> apiEndpoint = new ArrayList<>();
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ParticipantEntity participant;
}
