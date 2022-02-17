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
public class ServiceToServiceEntityMapper implements Converter<ServiceFromServiceBundle, ServiceFromServiceBundleEntity> {

    @Override
    @NonNull
    public ServiceFromServiceBundleEntity convert(final ServiceFromServiceBundle services) {
        return ServiceFromServiceBundleEntity.builder()
                .code(services.getCode())
                .chargingTriggerInfo(services.getChargingTriggerInfo())
                .eventLimitQuantity(services.getEventLimitQuantity())
                .freeEventQuantity(services.getFreeEventQuantity())
                .build();
    }

}
