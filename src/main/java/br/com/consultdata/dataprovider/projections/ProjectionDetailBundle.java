package br.com.consultdata.dataprovider.projections;

import java.math.BigDecimal;

public interface ProjectionDetailBundle {
    String getBundle();

    String getCode();

    String getInfo();

    int getEventLimit();

    int getFreeLimit();

    BigDecimal getMinimum();

    BigDecimal getMaximum();
    
}