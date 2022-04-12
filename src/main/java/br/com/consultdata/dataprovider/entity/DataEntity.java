package br.com.consultdata.dataprovider.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Table(name = "data")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    @OneToOne(mappedBy = "data", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Setter
    private BrandEntity brand;
}
