package br.com.consultdata.dataprovider.projections;

import java.math.BigDecimal;

public interface ProjectionBestLoan {
    String getBank();

    String getCompany();

    String getCustomerFriendlyLogoUri();

    BigDecimal getRate();

    BigDecimal getMinimum();

    BigDecimal getMaximum();

    long getRateId();
    
}