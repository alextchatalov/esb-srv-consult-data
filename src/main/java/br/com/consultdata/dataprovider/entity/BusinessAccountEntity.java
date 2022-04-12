package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "business_account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class BusinessAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToOne(mappedBy = "businessAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private FeesBusinessAccountsEntity fees;

    @OneToMany(mappedBy = "businessAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<ServiceBundleEntity> serviceBundles;

    @OneToMany(mappedBy = "businessAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<OpeningClosingChannelsEntity> openingClosingChannels;

    private String additionalInfo;

    @OneToMany(mappedBy = "businessAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<TransactionMethodsEntity> transactionMethods;

    @OneToOne(mappedBy = "businessAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private TermsConditionsEntity termsConditions;

    @OneToOne(mappedBy = "businessAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private IncomeRateEntity incomeRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CompanyEntity company;
}
