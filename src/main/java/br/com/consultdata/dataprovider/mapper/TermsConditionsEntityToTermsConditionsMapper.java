package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.TermsConditions;
import br.com.consultdata.dataprovider.entity.TermsConditionsEntity;
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
public class TermsConditionsEntityToTermsConditionsMapper implements Converter<TermsConditionsEntity, TermsConditions> {

    private final MinimumBalanceEntityToMinimumBalanceMapper minimumBalanceEntityToMinimumBalanceMapper;

    @Override
    @NonNull
    public TermsConditions convert(final TermsConditionsEntity termsConditionsEntity) {
        return TermsConditions.builder()
                .minimumBalance(minimumBalanceEntityToMinimumBalanceMapper.convert(termsConditionsEntity.getMinimumBalance()))
                .elegibilityCriteriaInfo(termsConditionsEntity.getElegibilityCriteriaInfo())
                .closingProcessInfo(termsConditionsEntity.getClosingProcessInfo())
                .build();
    }

}
