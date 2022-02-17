package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.core.model.ServiceFromServiceBundle;
import br.com.consultdata.dataprovider.entity.PriceEntity;
import br.com.consultdata.dataprovider.entity.ServiceBundleEntity;
import br.com.consultdata.dataprovider.entity.ServiceFromServiceBundleEntity;
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
public class ServiceBundleEntityToServiceBundleMapper implements Converter<ServiceBundleEntity, ServiceBundle> {

    private final PriceEntityToPriceMapper priceEntityToPriceMapper;
    private final MinimumEntityToMinimumMapper minimumEntityToMinimumMapper;
    private final MaximumEntityToMaximumMapper maximumEntityToMaximumMapper;
    private final ServiceEntityToServiceMapper serviceEntityToServiceMapper;

    @Override
    @NonNull
    public ServiceBundle convert(final ServiceBundleEntity serviceBundle) {
        return ServiceBundle.builder()
                .name(serviceBundle.getName())
                .services(convertListOfServicesEntityToListOfServices(serviceBundle.getServices()))
                .prices(convertListOfPricesEntityToListOfPrices(serviceBundle.getPrices()))
                .minimum(minimumEntityToMinimumMapper.convert(serviceBundle.getMinimum()))
                .maximum(maximumEntityToMaximumMapper.convert(serviceBundle.getMaximum()))
                .build();
    }

    private List<Price> convertListOfPricesEntityToListOfPrices(final List<PriceEntity> prices) {
        return prices.stream().map(priceEntityToPriceMapper::convert).collect(Collectors.toList());
    }

    private List<ServiceFromServiceBundle> convertListOfServicesEntityToListOfServices(final List<ServiceFromServiceBundleEntity> serviceFromServicePersonalAccounts) {
        return serviceFromServicePersonalAccounts.stream().map(serviceEntityToServiceMapper::convert).collect(Collectors.toList());
    }

}
