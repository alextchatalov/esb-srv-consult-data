package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Table(name = "interest_rate")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class IndexerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rate;

    @OneToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ApplicationEntity application;
}
