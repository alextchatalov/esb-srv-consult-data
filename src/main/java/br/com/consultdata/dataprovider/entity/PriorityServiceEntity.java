package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "priority_service")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class PriorityServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;
    private String chargingTriggerInfo;
    @OneToMany(mappedBy = "priorityService", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<PriceEntity> prices;
    @OneToOne(mappedBy = "priorityService", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private MinimumEntity minimum;
    @OneToOne(mappedBy = "priorityService", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private MaximumEntity maximum;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FeesPersonalAccountsEntity feesPersonalAccounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FeesLoanEntity feesLoan;
}
