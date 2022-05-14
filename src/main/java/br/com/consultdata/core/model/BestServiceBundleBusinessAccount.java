package br.com.consultdata.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class BestServiceBundleBusinessAccount {

    private String name;
    private String type;
    private BigDecimal minimum;
    private String minimumCurrency;
    private BigDecimal maximum;
    private String maximumCurrency;
    private String customerFriendlyLogoUri;
}