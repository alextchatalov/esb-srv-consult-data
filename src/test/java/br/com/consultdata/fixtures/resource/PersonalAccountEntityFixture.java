package br.com.bestbank.backbestbank.fixtures.resource;

import br.com.bestbank.getdataopenbanking.dataprovider.entity.CustomersEntity;
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
import br.com.bestbank.getdataopenbanking.dataprovider.entity.ServiceFromServiceBundleEntity;
import br.com.bestbank.getdataopenbanking.dataprovider.entity.TermsConditionsEntity;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;
import java.util.Collections;

public class PersonalAccountEntityFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(PersonalAccountEntity.class).addTemplate(VALID, new Rule() {{
            add(PersonalAccountEntity.Fields.type, "test");
            add("fees", createFees());
            add(PersonalAccountEntity.Fields.serviceBundles, Arrays.asList(createServiceBundles()));
            add(PersonalAccountEntity.Fields.openingClosingChannels, Arrays.asList("test"));
            add(PersonalAccountEntity.Fields.additionalInfo, "test");
            add(PersonalAccountEntity.Fields.transactionMethods, Arrays.asList("test"));
            add("termsConditions", createTermsConditions());
            add(PersonalAccountEntity.Fields.incomeRate, Arrays.asList(createIncomeRate()));

        }});
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