package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.ServiceBusinessAccounts;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.dataprovider.entity.ServiceBusinessAccountsEntity;
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
public class ServiceBusinessAccountsToServiceBusinessAccountsEntityMapper implements Converter<ServiceBusinessAccounts, ServiceBusinessAccountsEntity> {

    private final PriceEntityToPriceMapper priceEntityToPriceMapper;
    private final MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;
    private final MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;

    @Override
    @NonNull
    public ServiceBusinessAccountsEntity convert(final ServiceBusinessAccounts serviceBusinessAccounts) {
        return ServiceBusinessAccountsEntity.builder()
                .name(serviceBusinessAccounts.getName())
                .code(serviceBusinessAccounts.getCode())
                .chargingTriggerInfo(serviceBusinessAccounts.getChargingTriggerInfo())
                .prices(convertListOfPricesToListOfPricesEntity(serviceBusinessAccounts.getPrices()))
                .minimum(minimumEntityToMinimumMapper.convert(serviceBusinessAccounts.getMinimum()))
                .maximum(maximumEntityToMaximumMapper.convert(serviceBusinessAccounts.getMaximum()))
                .eventLimitQuantity(serviceBusinessAccounts.getEventLimitQuantity())
                .freeEventQuantity(serviceBusinessAccounts.getFreeEventQuantity())
                .build();
    }

    private List<PriceEntity> convertListOfPricesToListOfPricesEntity(final List<Price> prices) {
        return prices.stream().map(priceEntityToPriceMapper::convert).collect(Collectors.toList());

    }

}
