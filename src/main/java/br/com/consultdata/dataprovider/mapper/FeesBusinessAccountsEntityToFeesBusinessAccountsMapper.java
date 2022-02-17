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
public class FeesBusinessAccountsEntityToFeesBusinessAccountsMapper implements Converter<FeesBusinessAccountsEntity, FeesBusinessAccounts> {

    private final ServiceBusinessAccountsEntityToServiceBusinessAccountsMapper serviceBusinessAccountsEntityToServiceBusinessAccountsMapper;

    @Override
    @NonNull
    public FeesBusinessAccounts convert(final FeesBusinessAccountsEntity feesBusinessAccounts) {
        return FeesBusinessAccounts.builder()
                .services(convertListOfServiceBusinessAccountsEntityToListOfServiceBusinessAccounts(feesBusinessAccounts.getServices()))
                .build();
    }

    private List<ServiceBusinessAccounts> convertListOfServiceBusinessAccountsEntityToListOfServiceBusinessAccounts(final List<ServiceBusinessAccountsEntity> serviceBusinessAccounts) {
        return serviceBusinessAccounts.stream().map(serviceBusinessAccountsEntityToServiceBusinessAccountsMapper::convert).collect(Collectors.toList());
    }

}
