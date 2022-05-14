package br.com.consultdata.dataprovider.projections;

import java.math.BigDecimal;

public interface ProjectionBusinessAccountServiceBundle {
    String getName();
    String getType();
    BigDecimal getMinimum();
    String getMinimumCurrency();
    BigDecimal getMaximum();
    String getMaximumCurrency();

    String getCustomerFriendlyLogoUri();

}