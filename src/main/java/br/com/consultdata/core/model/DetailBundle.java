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
public class DetailBundle {

    private String bundle;
    private String code;
    private String info;
    private int eventLimit;
    private int freeLimit;
    private BigDecimal minimum;
    private BigDecimal maximum;
}
