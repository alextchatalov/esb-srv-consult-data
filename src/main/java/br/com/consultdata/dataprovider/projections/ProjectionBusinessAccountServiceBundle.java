package br.com.consultdata.dataprovider.projections;

import java.math.BigDecimal;

public interface ProjectionBusinessAccountServiceBundle {
    String getBank();

    String getBundleName();

    String getCustomerFriendlyLogoUri();

    BigDecimal getMinimum();

    BigDecimal getMaximum();

}