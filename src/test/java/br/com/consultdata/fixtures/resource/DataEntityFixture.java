package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.dataprovider.entity.BrandEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.BusinessAccountEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.CompanyEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.CustomersEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.DataEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.FeesBusinessAccountsEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.FeesEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.IncomeRateEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MaximumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumBalanceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.MinimumEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.OtherServiceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PersonalAccountEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.PriorityServiceEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceBusinessAccountsEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.TermsConditionsEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.time.LocalDateTime;
import java.util.Collections;

public class DataEntityFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(DataEntity.class).addTemplate(VALID, new Rule() {{
            add(DataEntity.Fields.id, "123");
            add(DataEntity.Fields.createDateTime, LocalDateTime.parse("2022-02-05T09:30:00.000"));
            add(DataEntity.Fields.lastModifiedDateTime, LocalDateTime.parse("2022-02-05T09:30:00.000"));
            add(DataEntity.Fields.brand, createBrand());

        }});
    }

    private BrandEntity createBrand() {

        return BrandEntity.builder()
                .name("test")
                .companies(Collections.singletonList(createCompany()))
                .build();
    }

    private CompanyEntity createCompany() {

        return CompanyEntity.builder()
                .name("test")
                .cnpjNumber("1244441")
                .urlComplementaryList("test")
                .personalAccounts(Collections.singletonList(createPersonalAccount()))
                .businessAccounts(Collections.singletonList(createBusinessAccount()))
                .build();
    }

    private BusinessAccountEntity createBusinessAccount() {
        return BusinessAccountEntity.builder()
                .type("test")
                .fees(createFeesBusiness())
                .serviceBundles(Collections.singletonList(createServiceBundles()))
                .openingClosingChannels(Collections.singletonList("test"))
                .additionalInfo("test")
                .transactionMethods(Collections.singletonList("test"))
                .termsConditions(createTermsConditions())
                .incomeRate(createIncomeRate())
                .build();
    }

    private FeesBusinessAccountsEntity createFeesBusiness() {

        return FeesBusinessAccountsEntity.builder()
                .services(Collections.singletonList(createServiceBusiness()))
                .build();
    }

    private ServiceBusinessAccountsEntity createServiceBusiness() {

        return ServiceBusinessAccountsEntity.builder()
                .name("test")
                .code("123")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }

    private PersonalAccountEntity createPersonalAccount() {

        return PersonalAccountEntity.builder()
                .type("test")
                .fees(createFees())
                .serviceBundles(Collections.singletonList(createServiceBundles()))
                .openingClosingChannels(Collections.singletonList("test"))
                .additionalInfo("test")
                .transactionMethods(Collections.singletonList("test"))
                .termsConditions(createTermsConditions())
                .incomeRate(Collections.singletonList(createIncomeRate()))
                .build();
    }

    private IncomeRateEntity createIncomeRate() {

        return IncomeRateEntity.builder()
                .savingAccount("123")
                .prepaidPaymentAccount("123")
                .build();
    }

    private TermsConditionsEntity createTermsConditions() {

        return TermsConditionsEntity.builder()
                .minimumBalance(createMinimumBalance())
                .elegibilityCriteriaInfo("test")
                .closingProcessInfo("1")
                .build();
    }

    private ServiceBundleEntity createServiceBundles() {

        return ServiceBundleEntity.builder()
                .name("test")
                .services(Collections.singletonList(createService()))
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private ServiceFromServiceBundleEntity createService() {

        return ServiceFromServiceBundleEntity.builder()
                .code("123")
                .chargingTriggerInfo("test")
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }

    private FeesEntity createFees() {

        return FeesEntity.builder()
                .priorityServices(Collections.singletonList(createPriorityService()))
                .otherServices(Collections.singletonList(createOtherService()))
                .build();
    }


    private OtherServiceEntity createOtherService() {

        return OtherServiceEntity.builder()
                .name("test")
                .code("test")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private PriorityServiceEntity createPriorityService() {
        return PriorityServiceEntity.builder()
                .name("test")
                .code("test")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private MaximumEntity createMaximum() {

        return MaximumEntity.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private MinimumEntity createMinimum() {

        return MinimumEntity.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private PriceEntity createPrice() {
        return PriceEntity.builder()
                .interval("123")
                .value("123")
                .currency("123")
                .customers(createCustomers())
                .monthlyFee("123")
                .build();
    }

    private CustomersEntity createCustomers() {

        return CustomersEntity.builder()
                .rate("123")
                .build();
    }

    private MinimumBalanceEntity createMinimumBalance() {
        return MinimumBalanceEntity.builder()
                .currency("123")
                .value("123")
                .build();
    }
}
