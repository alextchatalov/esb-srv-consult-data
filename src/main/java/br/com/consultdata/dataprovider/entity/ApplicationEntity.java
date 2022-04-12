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
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String interval;
    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private IndexerEntity indexer;
    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private CustomersEntity customers;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private InterestRateEntity interestRate;
}
