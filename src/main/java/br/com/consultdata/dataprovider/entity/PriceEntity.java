package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Table(name = "price")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String interval;
    private String value;
    private String currency;
    @OneToOne(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private CustomersEntity customers;
    private String monthlyFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PriorityServiceEntity priorityService;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private OtherServiceEntity otherService;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ServiceBundleEntity serviceBundle;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ServiceBusinessAccountsEntity serviceBusinessAccounts;
}
