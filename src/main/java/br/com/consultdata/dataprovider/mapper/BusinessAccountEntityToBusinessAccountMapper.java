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
public class BusinessAccountToBusinessAccountMapper implements Converter<BusinessAccount, BusinessAccountEntity> {

    private final FeesBusinessAccountsToFeesBusinessAccountsEntityMapper feesBusinessAccountsToFeesBusinessAccountsEntityMapper;
    private final ServiceBundleToServiceBundleEntityMapper serviceBundleToServiceBundleEntityMapper;
    private final TermsConditionsToTermsConditionsEntityMapper termsConditionsToTermsConditionsEntityMapper;
    private final IncomeRateToIncomeRateEntityMapper incomeRateToIncomeRateEntityMapper;

    @Override
    @NonNull
    public BusinessAccountEntity convert(final BusinessAccount businessAccount) {
        return BusinessAccountEntity.builder()
                .type(businessAccount.getType())
                .fees(feesBusinessAccountsToFeesBusinessAccountsEntityMapper.convert(businessAccount.getFees())) //TODO criar um novo mapper para o busniess
                .serviceBundles(convertListOfServiceBundleToListOfServiceBundleEntity(businessAccount.getServiceBundles()))
                .openingClosingChannels(businessAccount.getOpeningClosingChannels())
                .additionalInfo(businessAccount.getAdditionalInfo())
                .transactionMethods(businessAccount.getTransactionMethods())
                .termsConditions(termsConditionsToTermsConditionsEntityMapper.convert(businessAccount.getTermsConditions()))
                .incomeRate(incomeRateToIncomeRateEntityMapper.convert(businessAccount.getIncomeRate()))
                .build();
    }

    private List<ServiceBundleEntity> convertListOfServiceBundleToListOfServiceBundleEntity(final List<ServiceBundle> serviceBundles) {
        return serviceBundles.stream().map(serviceBundleToServiceBundleEntityMapper::convert).collect(Collectors.toList());
    }

}
