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
public class PriorityServiceToPriorityServiceEntityMapper implements Converter<PriorityService, PriorityServiceEntity> {

    private final PriceEntityToPriceMapper priceEntityToPriceMapper;
    private final MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;
    private final MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;

    @Override
    @NonNull
    public PriorityServiceEntity convert(final PriorityService priorityService) {
        return PriorityServiceEntity.builder()
                .name(priorityService.getName())
                .code(priorityService.getCode())
                .chargingTriggerInfo(priorityService.getChargingTriggerInfo())
                .prices(convertListOfPricesToListOfPricesEntity(priorityService.getPrices()))
                .minimum(minimumEntityToMinimumMapper.convert(priorityService.getMinimum()))
                .maximum(maximumEntityToMaximumMapper.convert(priorityService.getMaximum()))
                .build();
    }

    private List<PriceEntity> convertListOfPricesToListOfPricesEntity(final List<Price> prices) {
        return prices.stream().map(priceEntityToPriceMapper::convert).collect(Collectors.toList());
    }

}
