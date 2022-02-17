package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.MinimumBalance;
import br.com.consultdata.dataprovider.entity.MinimumBalanceEntity;
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
public class MinimumBalanceEntityToMinimumBalanceMapper implements Converter<MinimumBalanceEntity, MinimumBalance> {


    @Override
    @NonNull
    public MinimumBalance convert(final MinimumBalanceEntity minimumBalanceEntity) {
        return MinimumBalance.builder()
                .value(minimumBalanceEntity.getValue())
                .currency(minimumBalanceEntity.getCurrency())
                .build();
    }

}
