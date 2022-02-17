package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.ServiceFromServiceBundle;
import br.com.consultdata.dataprovider.entity.ServiceFromServiceBundleEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
@AllArgsConstructor
@EqualsAndHashCode
public class ServiceEntityToServiceMapper implements Converter<ServiceFromServiceBundleEntity, ServiceFromServiceBundle> {

    @Override
    @NonNull
    public ServiceFromServiceBundle convert(final ServiceFromServiceBundleEntity services) {
        return ServiceFromServiceBundle.builder()
                .code(services.getCode())
                .chargingTriggerInfo(services.getChargingTriggerInfo())
                .eventLimitQuantity(services.getEventLimitQuantity())
                .freeEventQuantity(services.getFreeEventQuantity())
                .build();
    }

}
