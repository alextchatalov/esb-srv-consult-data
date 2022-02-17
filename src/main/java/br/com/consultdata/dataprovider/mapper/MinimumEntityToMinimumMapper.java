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
public class MinimumEntityToMinimumMapper implements Converter<MinimumEntity, Minimum> {

    @Override
    @NonNull
    public Minimum convert(final MinimumEntity minimum) {
        return Minimum.builder()
                .value(minimum.getValue())
                .currency(minimum.getCurrency())
                .build();
    }
}
