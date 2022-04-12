package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_business_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class ServiceBusinessAccountsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;
    public String code;
    public String chargingTriggerInfo;

    @OneToMany(mappedBy = "serviceBusinessAccounts", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    public List<PriceEntity> prices;

    @OneToOne(mappedBy = "serviceBusinessAccounts", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    public MinimumEntity minimum;

    @OneToOne(mappedBy = "serviceBusinessAccounts", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    public MaximumEntity maximum;

    public String eventLimitQuantity;
    public String freeEventQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private FeesBusinessAccountsEntity feesBusinessAccounts;
}
