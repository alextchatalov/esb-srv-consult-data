package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BusinessAccount;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.dataprovider.entity.BusinessAccountEntity;
import br.com.consultdata.dataprovider.entity.ServiceBundleEntity;
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
public class BusinessAccountEntityToBusinessAccountMapper implements Converter<BusinessAccountEntity, BusinessAccount> {

    private final FeesBusinessAccountsEntityToFeesBusinessAccountsMapper feesBusinessAccountsEntityToFeesBusinessAccountsMapper;
    private final ServiceBundleEntityToServiceBundleMapper serviceBundleEntityToServiceBundleMapper;
    private final TermsConditionsEntityToTermsConditionsMapper termsConditionsEntityToTermsConditionsMapper;
    private final IncomeRateEntityToIncomeRateMapper incomeRateEntityToIncomeRateMapper;

    @Override
    @NonNull
    public BusinessAccount convert(final BusinessAccountEntity businessAccountEntity) {
        return BusinessAccount.builder()
                .type(businessAccountEntity.getType())
                .fees(feesBusinessAccountsEntityToFeesBusinessAccountsMapper.convert(businessAccountEntity.getFees()))
                .serviceBundles(convertListOfServiceBundleEntityToListOfServiceBundle(businessAccountEntity.getServiceBundles()))
                .openingClosingChannels(businessAccountEntity.getOpeningClosingChannels())
                .additionalInfo(businessAccountEntity.getAdditionalInfo())
                .transactionMethods(businessAccountEntity.getTransactionMethods())
                .termsConditions(termsConditionsEntityToTermsConditionsMapper.convert(businessAccountEntity.getTermsConditions()))
                .incomeRate(incomeRateEntityToIncomeRateMapper.convert(businessAccountEntity.getIncomeRate()))
                .build();
    }

    private List<ServiceBundle> convertListOfServiceBundleEntityToListOfServiceBundle(final List<ServiceBundleEntity> serviceBundles) {
        return serviceBundles.stream().map(serviceBundleEntityToServiceBundleMapper::convert).collect(Collectors.toList());
    }

}
