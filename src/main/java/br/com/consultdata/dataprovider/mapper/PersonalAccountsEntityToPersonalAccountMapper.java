package br.com.consultdata.dataprovider.mapper;
import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.core.model.PersonalAccount;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.dataprovider.entity.IncomeRateEntity;
import br.com.consultdata.dataprovider.entity.PersonalAccountEntity;
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
public class PersonalAccountsEntityToPersonalAccountMapper implements Converter<PersonalAccountEntity, PersonalAccount> {

    private final FeesPersonalAccountsEntityToFeesPersonalAccountsMapper feesPersonalAccountsEntityToFeesPersonalAccountsMapper;
    private final ServiceBundleEntityToServiceBundleMapper serviceBundleEntityToServiceBundleMapper;
    private final TermsConditionsEntityToTermsConditionsMapper termsConditionsEntityToTermsConditionsMapper;
    private final IncomeRateEntityToIncomeRateMapper incomeRateEntityToIncomeRateMapper;

    @Override
    @NonNull
    public PersonalAccount convert(final PersonalAccountEntity personalAccount) {
        return PersonalAccount.builder()
                .type(personalAccount.getType())
                .fees(feesPersonalAccountsEntityToFeesPersonalAccountsMapper.convert(personalAccount.getFees()))
                .serviceBundles(convertListOfServiceBundleEntityToListOfServiceBundle(personalAccount.getServiceBundles()))
                .openingClosingChannels(personalAccount.getOpeningClosingChannels())
                .additionalInfo(personalAccount.getAdditionalInfo())
                .transactionMethods(personalAccount.getTransactionMethods())
                .termsConditions(termsConditionsEntityToTermsConditionsMapper.convert(personalAccount.getTermsConditions()))
                .incomeRate(convertListOfIncomeRateEntityToListOfIncomeRate(personalAccount.getIncomeRate()))
                .build();
    }

    private List<ServiceBundle> convertListOfServiceBundleEntityToListOfServiceBundle(final List<ServiceBundleEntity> serviceBundles) {
        return serviceBundles.stream().map(serviceBundleEntityToServiceBundleMapper::convert).collect(Collectors.toList());
    }

    private List<IncomeRate> convertListOfIncomeRateEntityToListOfIncomeRate(final List<IncomeRateEntity> incomeRates) {
        return incomeRates.stream().map(incomeRateEntityToIncomeRateMapper::convert).collect(Collectors.toList());
    }

}
