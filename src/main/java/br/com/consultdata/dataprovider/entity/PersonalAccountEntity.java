package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personal_account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class PersonalAccountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToOne(mappedBy = "personalAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private FeesPersonalAccountsEntity fees;

    @OneToMany(mappedBy = "personalAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<ServiceBundleEntity> serviceBundles;

    @OneToMany(mappedBy = "personalAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<OpeningClosingChannelsEntity> openingClosingChannels;

    private String additionalInfo;

    @OneToMany(mappedBy = "personalAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<TransactionMethodsEntity> transactionMethods;

    @OneToOne(mappedBy = "personalAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private TermsConditionsEntity termsConditions;

    @OneToMany(mappedBy = "personalAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<IncomeRateEntity> incomeRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CompanyEntity company;
}
