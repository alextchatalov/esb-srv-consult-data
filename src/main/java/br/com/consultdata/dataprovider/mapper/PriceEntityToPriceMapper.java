package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Price;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
@AllArgsConstructor
public class PriceToPriceEntityMapper implements Converter<Price, PriceEntity> {

    private final CustomersEntityToCustomersMapper customersEntityToCustomersMapper;

    @Override
    @NonNull
    public PriceEntity convert(final Price price) {
        return PriceEntity.builder()
                .interval(price.getInterval())
                .value(price.getValue())
                .currency(price.getCurrency())
                .customers(customersEntityToCustomersMapper.convert(price.getCustomers()))
                .monthlyFee(price.getMonthlyFee())
                .build();
    }

}
