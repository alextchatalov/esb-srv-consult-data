package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_bundle")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class ServiceBundleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "serviceBundle", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<ServiceFromServiceBundleEntity> services;

    @OneToMany(mappedBy = "serviceBundle", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<PriceEntity> prices;

    @OneToOne(mappedBy = "serviceBundle", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private MinimumEntity minimum;

    @OneToOne(mappedBy = "serviceBundle", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private MaximumEntity maximum;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PersonalAccountEntity personalAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private BusinessAccountEntity businessAccount;
}
