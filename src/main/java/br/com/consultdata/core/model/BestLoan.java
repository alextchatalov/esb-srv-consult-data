package br.com.consultdata.core.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@FieldNameConstants
@EqualsAndHashCode
@ToString
public class BestLoan {

    private String bank;
    private String company;
    private String customerFriendlyLogoUri;
    private BigDecimal minimum;
    private BigDecimal maximum;
    private long rateId;
    private BigDecimal rate;
}