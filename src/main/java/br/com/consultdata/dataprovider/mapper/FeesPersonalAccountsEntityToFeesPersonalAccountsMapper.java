package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.FeesPersonalAccounts;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.PriorityService;
import br.com.consultdata.dataprovider.entity.FeesPersonalAccountsEntity;
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
public class FeesPersonalAccountsEntityToFeesPersonalAccountsMapper implements Converter<FeesPersonalAccountsEntity, FeesPersonalAccounts> {

    private final PriorityServiceEntityToPriorityServiceMapper priorityServiceEntityToPriorityServiceMapper;
    private final OtherServiceEntityToOtherServiceMapper otherServiceEntityToOtherServiceMapper;

    @Override
    @NonNull
    public FeesPersonalAccounts convert(final FeesPersonalAccountsEntity feesPersonalAccounts) {
        return FeesPersonalAccounts.builder()
                .priorityServices(convertListOfPriorityServicesEntityToListOfPriorityServices(feesPersonalAccounts.getPriorityServices()))
                .otherServices(convertListOfOtherServicesEntityToListOfOtherServices(feesPersonalAccounts.getOtherServices()))
                .build();
    }

    private List<PriorityService> convertListOfPriorityServicesEntityToListOfPriorityServices(final List<PriorityServiceEntity> priorityServices) {
        return priorityServices.stream().map(priorityServiceEntityToPriorityServiceMapper::convert).collect(Collectors.toList());
    }

    private List<OtherService> convertListOfOtherServicesEntityToListOfOtherServices(final List<OtherServiceEntity> otherServices) {
        return otherServices.stream().map(otherServiceEntityToOtherServiceMapper::convert).collect(Collectors.toList());
    }

}