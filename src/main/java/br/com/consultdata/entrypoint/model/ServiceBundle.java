package br.com.consultdata.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class ServiceBundle {

    private String name;
    private List<Service> services;
    private BigDecimal minimumValue;
    private BigDecimal maximumValue;

}
