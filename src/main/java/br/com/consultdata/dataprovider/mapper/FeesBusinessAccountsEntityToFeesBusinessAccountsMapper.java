package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.FeesBusinessAccounts;
import br.com.consultdata.core.model.ServiceBusinessAccounts;
import br.com.consultdata.dataprovider.entity.FeesBusinessAccountsEntity;
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
public class FeesBusinessAccountsToFeesBusinessAccountsEntityMapper implements Converter<FeesBusinessAccounts, FeesBusinessAccountsEntity> {

    private final ServiceBusinessAccountsEntityToServiceBusinessAccountsMapper serviceBusinessAccountsEntityToServiceBusinessAccountsMapper;

    @Override
    @NonNull
    public FeesBusinessAccountsEntity convert(final FeesBusinessAccounts feesBusinessAccounts) {
        return FeesBusinessAccountsEntity.builder()
                .services(convertListOfServiceBusinessAccountsToListOfServiceBusinessAccountsEntity(feesBusinessAccounts.getServices()))
                .build();
    }

    private List<ServiceBusinessAccountsEntity> convertListOfServiceBusinessAccountsToListOfServiceBusinessAccountsEntity(final List<ServiceBusinessAccounts> serviceBusinessAccounts) {
        return serviceBusinessAccounts.stream().map(serviceBusinessAccountsEntityToServiceBusinessAccountsMapper::convert).collect(Collectors.toList());
    }

}
