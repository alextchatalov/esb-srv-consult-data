package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.dataprovider.entity.IncomeRateEntity;
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
public class IncomeRateToIncomeRateEntityMapper implements Converter<IncomeRate, IncomeRateEntity> {


    @Override
    @NonNull
    public IncomeRateEntity convert(final IncomeRate incomeRate) {
        return IncomeRateEntity.builder()
                .savingAccount(incomeRate.getSavingAccount())
                .prepaidPaymentAccount(incomeRate.getPrepaidPaymentAccount())
                .build();
    }

}
