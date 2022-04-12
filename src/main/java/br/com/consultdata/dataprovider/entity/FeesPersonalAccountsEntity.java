package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fees_personal_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class FeesPersonalAccountsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "feesPersonalAccounts", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<PriorityServiceEntity> priorityServices;
    @OneToMany(mappedBy = "feesPersonalAccounts", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<OtherServiceEntity> otherServices;

    @OneToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PersonalAccountEntity personalAccount;
}
