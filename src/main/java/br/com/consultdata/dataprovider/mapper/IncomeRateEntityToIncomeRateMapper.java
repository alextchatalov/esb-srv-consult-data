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
public class IncomeRateEntityToIncomeRateMapper implements Converter<IncomeRateEntity, IncomeRate> {


    @Override
    @NonNull
    public IncomeRate convert(final IncomeRateEntity incomeRate) {
        return IncomeRate.builder()
                .savingAccount(incomeRate.getSavingAccount())
                .prepaidPaymentAccount(incomeRate.getPrepaidPaymentAccount())
                .build();
    }

}
