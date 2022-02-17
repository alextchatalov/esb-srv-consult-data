package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.dataprovider.entity.OtherServiceEntity;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Lazy
@Component
@AllArgsConstructor
public class OtherServiceEntityToOtherServiceMapper implements Converter<OtherServiceEntity, OtherService> {

    private final PriceEntityToPriceMapper priceEntityToPriceMapper;
    private final MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;
    private final MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;

    @Override
    @NonNull
    public OtherService convert(final OtherServiceEntity otherService) {
        return OtherService.builder()
                .name(otherService.getName())
                .code(otherService.getCode())
                .chargingTriggerInfo(otherService.getChargingTriggerInfo())
                .prices(convertListOfPricesEntityToListOfPrices(otherService.getPrices()))
                .minimum(minimumEntityToMinimumMapper.convert(otherService.getMinimum()))
                .maximum(maximumEntityToMaximumMapper.convert(otherService.getMaximum()))
                .build();
    }

    private List<Price> convertListOfPricesEntityToListOfPrices(final List<PriceEntity> prices) {
        return prices.stream().map(priceEntityToPriceMapper::convert).collect(Collectors.toList());

    }
}
