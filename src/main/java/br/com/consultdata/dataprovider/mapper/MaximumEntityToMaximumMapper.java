package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.dataprovider.entity.MaximumEntity;
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
public class MaximumToMaximumEntityMapper implements Converter<Maximum, MaximumEntity> {

    @Override
    @NonNull
    public MaximumEntity convert(final Maximum maximum) {
        return MaximumEntity.builder()
                .value(maximum.getValue())
                .currency(maximum.getCurrency())
                .build();
    }
}
