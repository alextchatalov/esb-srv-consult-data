package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Customers;
import br.com.consultdata.dataprovider.entity.CustomersEntity;
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
public class CustomersToCustomersEntityMapper implements Converter<Customers, CustomersEntity> {

    @Override
    @NonNull
    public CustomersEntity convert(final Customers customers) {
        return CustomersEntity.builder()
                .rate(customers.getRate())
                .build();
    }

}
