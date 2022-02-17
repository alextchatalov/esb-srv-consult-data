package br.com.consultdata.fixtures.resource;

import br.com.consultdata.core.model.Customers;
import br.com.consultdata.core.model.FeesPersonalAccounts;
import br.com.consultdata.core.model.IncomeRate;
import br.com.consultdata.core.model.Maximum;
import br.com.consultdata.core.model.Minimum;
import br.com.consultdata.core.model.MinimumBalance;
import br.com.consultdata.core.model.OtherService;
import br.com.consultdata.core.model.PersonalAccount;
import br.com.consultdata.core.model.Price;
import br.com.consultdata.core.model.PriorityService;
import br.com.consultdata.core.model.ServiceBundle;
import br.com.consultdata.core.model.ServiceFromServiceBundle;
import br.com.consultdata.core.model.TermsConditions;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.util.Arrays;
import java.util.Collections;

public class PersonalAccountFixture implements TemplateLoader {

    public static final String VALID = "valid";

    @Override
    public void load() {
        loadData();
    }

    private void loadData() {
        Fixture.of(PersonalAccount.class).addTemplate(VALID, new Rule() {{
            add(PersonalAccount.Fields.type, "test");
            add("fees", createFees());
            add(PersonalAccount.Fields.serviceBundles, Arrays.asList(createServiceBundles()));
            add(PersonalAccount.Fields.openingClosingChannels, Arrays.asList("test"));
            add(PersonalAccount.Fields.additionalInfo, "test");
            add(PersonalAccount.Fields.transactionMethods, Arrays.asList("test"));
            add("termsConditions", createTermsConditions());
            add(PersonalAccount.Fields.incomeRate, Arrays.asList(createIncomeRate()));

        }});
    }

    private IncomeRate createIncomeRate() {

        return IncomeRate.builder()
                .savingAccount("123")
                .prepaidPaymentAccount("123")
                .build();
    }

    private TermsConditions createTermsConditions() {

        return TermsConditions.builder()
                .minimumBalance(createMinimumBalance())
                .elegibilityCriteriaInfo("test")
                .closingProcessInfo("1")
                .build();
    }

    private ServiceBundle createServiceBundles() {

        return ServiceBundle.builder()
                .name("test")
                .services(Collections.singletonList(createService()))
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private ServiceFromServiceBundle createService() {

        return ServiceFromServiceBundle.builder()
                .code("123")
                .chargingTriggerInfo("test")
                .eventLimitQuantity("1")
                .freeEventQuantity("1")
                .build();
    }

    private FeesPersonalAccounts createFees() {

        return FeesPersonalAccounts.builder()
                .priorityServices(Collections.singletonList(createPriorityService()))
                .otherServices(Collections.singletonList(createOtherService()))
                .build();
    }


    private OtherService createOtherService() {

        return OtherService.builder()
                .name("test")
                .code("test")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private PriorityService createPriorityService() {
        return PriorityService.builder()
                .name("test")
                .code("test")
                .chargingTriggerInfo("test")
                .prices(Collections.singletonList(createPrice()))
                .minimum(createMinimum())
                .maximum(createMaximum())
                .build();
    }

    private Maximum createMaximum() {

        return Maximum.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private Minimum createMinimum() {

        return Minimum.builder()
                .currency("123")
                .value("123")
                .build();
    }

    private Price createPrice() {
        return Price.builder()
                .interval("123")
                .value("123")
                .currency("123")
                .customers(createCustomers())
                .monthlyFee("123")
                .build();
    }

    private Customers createCustomers() {

        return Customers.builder()
                .rate("123")
                .build();
    }

    private MinimumBalance createMinimumBalance() {
        return MinimumBalance.builder()
                .currency("123")
                .value("123")
                .build();
    }
}