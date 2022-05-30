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

    private String bank;
    private String bundleName;
    private String customerFriendlyLogoUri;
    private BigDecimal minimum;
    private BigDecimal maximum;
}