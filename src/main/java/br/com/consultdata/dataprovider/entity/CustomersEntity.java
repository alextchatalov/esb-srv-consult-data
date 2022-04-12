package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rate;

    @OneToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PriceEntity price;

    @OneToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ApplicationEntity application;
}
