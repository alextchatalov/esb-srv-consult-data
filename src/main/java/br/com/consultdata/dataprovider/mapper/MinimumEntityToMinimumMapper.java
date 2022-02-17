package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.dataprovider.entity.MinimumEntity;
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
public class MinimumToMinimumEntityMapper implements Converter<Minimum, MinimumEntity> {

    @Override
    @NonNull
    public MinimumEntity convert(final Minimum minimum) {
        return MinimumEntity.builder()
                .value(minimum.getValue())
                .currency(minimum.getCurrency())
                .build();
    }
}
