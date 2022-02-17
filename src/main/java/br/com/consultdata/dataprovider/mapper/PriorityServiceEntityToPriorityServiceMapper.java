package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.PriorityService;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.dataprovider.entity.PriorityServiceEntity;
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
public class PriorityServiceEntityToPriorityServiceMapper implements Converter<PriorityServiceEntity, PriorityService> {

    private final PriceEntityToPriceMapper priceEntityToPriceMapper;
    private final MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;
    private final MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;

    @Override
    @NonNull
    public PriorityService convert(final PriorityServiceEntity priorityService) {
        return PriorityService.builder()
                .name(priorityService.getName())
                .code(priorityService.getCode())
                .chargingTriggerInfo(priorityService.getChargingTriggerInfo())
                .prices(convertListOfPricesEntityToListOfPrices(priorityService.getPrices()))
                .minimum(minimumEntityToMinimumMapper.convert(priorityService.getMinimum()))
                .maximum(maximumEntityToMaximumMapper.convert(priorityService.getMaximum()))
                .build();
    }

    private List<Price> convertListOfPricesEntityToListOfPrices(final List<PriceEntity> prices) {
        return prices.stream().map(priceEntityToPriceMapper::convert).collect(Collectors.toList());
    }

}
