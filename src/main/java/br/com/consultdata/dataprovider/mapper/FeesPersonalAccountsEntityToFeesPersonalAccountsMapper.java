package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.FeesPersonalAccounts;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.PriorityService;
import br.com.consultdata.dataprovider.entity.FeesEntity;
import br.com.consultdata.dataprovider.entity.OtherServiceEntity;
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
public class FeesPersonalAccountsToFeesPersonalAccountsEntityMapper implements Converter<FeesPersonalAccounts, FeesEntity> {

    private final PriorityServiceEntityToPriorityServiceMapper priorityServiceEntityToPriorityServiceMapper;
    private final OtherServiceEntityToOtherServiceMapper otherServiceEntityToOtherServiceMapper;

    @Override
    @NonNull
    public FeesEntity convert(final FeesPersonalAccounts feesPersonalAccounts) {
        return FeesEntity.builder()
                .priorityServices(convertListOfPriorityServicesToListOfPriorityServicesEntity(feesPersonalAccounts.getPriorityServices()))
                .otherServices(convertListOfOtherServicesToListOfOtherServicesEntity(feesPersonalAccounts.getOtherServices()))
                .build();
    }

    private List<PriorityServiceEntity> convertListOfPriorityServicesToListOfPriorityServicesEntity(final List<PriorityService> priorityServices) {
        return priorityServices.stream().map(priorityServiceEntityToPriorityServiceMapper::convert).collect(Collectors.toList());
    }

    private List<OtherServiceEntity> convertListOfOtherServicesToListOfOtherServicesEntity(final List<OtherService> otherServices) {
        return otherServices.stream().map(otherServiceEntityToOtherServiceMapper::convert).collect(Collectors.toList());
    }

}
