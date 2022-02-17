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
public class CompanyToCompanyEntityMapper implements Converter<Company, CompanyEntity> {

    private final PersonalAccountsEntityToPersonalAccountMapper personalAccountsEntityToPersonalAccountMapper;
    private final BusinessAccountEntityToBusinessAccountMapper businessAccountEntityToBusinessAccountMapper;

    @Override
    @NonNull
    public CompanyEntity convert(final Company company) {
        return CompanyEntity.builder()
                .cnpjNumber(company.getCnpjNumber())
                .name(company.getName())
                .personalAccounts(convertPersonalAccountsListToPersonalAccountEntityList(company.getPersonalAccounts()))
                .businessAccounts(convertBusinessAccountListToBusinessAccountEntityList(company.getBusinessAccounts()))
                .urlComplementaryList(company.getUrlComplementaryList())
                .build();
    }

    private List<PersonalAccountEntity> convertPersonalAccountsListToPersonalAccountEntityList(final List<PersonalAccount> personalAccounts) {
        if (personalAccounts != null && !personalAccounts.isEmpty()) {
            return personalAccounts.stream().map(personalAccountsEntityToPersonalAccountMapper::convert).collect(Collectors.toList());
        }
        return null;
    }

    private List<BusinessAccountEntity> convertBusinessAccountListToBusinessAccountEntityList(final List<BusinessAccount> businessAccounts) {
        if (businessAccounts != null && !businessAccounts.isEmpty()) {
            return businessAccounts.stream().map(businessAccountEntityToBusinessAccountMapper::convert).collect(Collectors.toList());
        }
        return null;
    }
}
