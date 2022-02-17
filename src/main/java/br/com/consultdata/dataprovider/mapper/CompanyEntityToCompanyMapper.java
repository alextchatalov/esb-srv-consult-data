package br.com.consultdata.dataprovider.mapper;

import br.com.consultdata.core.model.BusinessAccount;
import br.com.consultdata.core.model.Company;
import br.com.consultdata.core.model.PersonalAccount;
import br.com.consultdata.dataprovider.entity.BusinessAccountEntity;
import br.com.consultdata.dataprovider.entity.CompanyEntity;
import br.com.consultdata.dataprovider.entity.PersonalAccountEntity;
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
public class CompanyEntityToCompanyMapper implements Converter<CompanyEntity, Company> {

    private final PersonalAccountsEntityToPersonalAccountMapper personalAccountsEntityToPersonalAccountMapper;
    private final BusinessAccountEntityToBusinessAccountMapper businessAccountEntityToBusinessAccountMapper;

    @Override
    @NonNull
    public Company convert(final CompanyEntity company) {
        return Company.builder()
                .cnpjNumber(company.getCnpjNumber())
                .name(company.getName())
                .personalAccounts(convertPersonalAccountsEntityListToPersonalAccountList(company.getPersonalAccounts()))
                .businessAccounts(convertBusinessAccountEntityListToBusinessAccountList(company.getBusinessAccounts()))
                .urlComplementaryList(company.getUrlComplementaryList())
                .build();
    }

    private List<PersonalAccount> convertPersonalAccountsEntityListToPersonalAccountList(final List<PersonalAccountEntity> personalAccounts) {
        if (personalAccounts != null && !personalAccounts.isEmpty()) {
            return personalAccounts.stream().map(personalAccountsEntityToPersonalAccountMapper::convert).collect(Collectors.toList());
        }
        return null;
    }

    private List<BusinessAccount> convertBusinessAccountEntityListToBusinessAccountList(final List<BusinessAccountEntity> businessAccounts) {
        if (businessAccounts != null && !businessAccounts.isEmpty()) {
            return businessAccounts.stream().map(businessAccountEntityToBusinessAccountMapper::convert).collect(Collectors.toList());
        }
        return null;
    }
}
