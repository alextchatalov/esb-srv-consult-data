package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "business_loan")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class BusinessLoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToOne(mappedBy = "businessLoan", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private FeesLoanEntity fees;

    @OneToMany(mappedBy = "businessLoan", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<InterestRateEntity> interestRates;

    @OneToMany(mappedBy = "businessLoan", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<RequiredWarrantiesEntity> requiredWarranties;

    private String termsConditions;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CompanyEntity company;
}
